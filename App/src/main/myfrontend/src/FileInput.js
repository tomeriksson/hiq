import React, { Fragment, useState } from 'react';
import Message from './Message';
import Progress from './Progress';
import axios from 'axios';

const FileInput = () => {
    const [file, setFile] = useState('');
    const [filename, setFilename] = useState('Choose File');
    const [uploadedFile, setUploadedFile] = useState({});
    const [message, setMessage] = useState('');
    const [uploadPercentage, setUploadPercentage] = useState(0);
    const [text, setText] = useState('');

    const onChange = e => {
        setFile(e.target.files[0]);
        setFilename(e.target.files[0].name);
    };

    const onSubmit = async e => {
        e.preventDefault();
        const formData = new FormData();
        formData.append('file', file);

        const res = await axios.post('/process/file', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            onUploadProgress: progressEvent => {
                setUploadPercentage(
                    parseInt(
                        Math.round((progressEvent.loaded * 100) / progressEvent.total)
                    )
                );

                // Clear percentage
                setTimeout(() => setUploadPercentage(0), 10000);
            }
        }).then(response => {
            setMessage('File Uploaded');
            setText(response.data.content);
            const {fileName, filePath} = res.data;
            setUploadedFile({fileName, filePath});
        }).catch(error => {
            if (error.response.data.status === 400){
                setMessage(error.response.data.error + ": " + error.response.data.message);
            }else if(error.response.data.status === 500){
                setMessage("Something went wrong with the server.");
            }else{
                setMessage("Oups! Something went wrong!");
            }
        });
    }
    return (
        <Fragment>
            {message ? <Message msg={message} /> : null}
            <form onSubmit={onSubmit}>
                <div className='custom-file mb-4'>
                    <input
                        type='file'
                        className='custom-file-input'
                        id='customFile'
                        onChange={onChange}
                    />
                    <label className='custom-file-label' htmlFor='customFile'>
                        {filename}
                    </label>
                </div>

                <Progress percentage={uploadPercentage} />

                <input
                    type='submit'
                    value='Upload'
                    className='btn btn-primary btn-block mt-4'
                />
            </form>
            {uploadedFile ? (
                <div className='row mt-5'>
                    <div className='col-md-6 m-auto'>
                        <h3 className='text-center'>{uploadedFile.fileName}</h3>
                        <img style={{ width: '100%' }} src={uploadedFile.filePath} alt='' />
                    </div>
                </div>
            ) : null}
            <div className='col-md-auto col-sm-auto col-lg-auto col-xl-auto col-xs-auto'>
                <h2 className="text-center">Foo-Bar'ed Text</h2>
                <div className="card-body">
                    <div className="card-text">
                    <pre>{text ? (text): ''}</pre>
                    </div>
                </div>
            </div>
        </Fragment>
    );
};

export default FileInput;

import React from 'react';
import FileInput from './FileInput';
import './App.css';

const App = () => (
    <div className='container mt-4'>
        <h4 className='display-4 text-center mb-4'>
            <i className='fab fa-react' /> React Foo-Bar Text Transformer
        </h4>

        <FileInput />
    </div>
);

export default App;

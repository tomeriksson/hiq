import React, {Component} from "react";

class PostForm extends Component{
    constructor(props) {
        super();
        this.state = {
         text: ''
        }
    }
    changeHandler = (e) => {
      this.setState({[e.target.name]: e.target.value})
    }

    submitHandler = e => {
      e.preventDefault()
      console.log(this.state)
    }
    render(){
        const {text} = this.state
        return(
            <div>
                <form onSubmit={this.submitHandler}>
                    <div>
                        <input type="text" name="text" vaule={text} onChange={this.changeHandler} />
                    </div>
                    <button type="submit">Submit</button>
                </form>
            </div>
        )
}
}

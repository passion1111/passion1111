import React, { Component } from 'react'
import './App.css'
import Validation from './Vaildation/Validation'
import Char from './char/Char'


class App2 extends Component {
    state={
        usrInput:''
    }


    inputChangeHandler=(e)=>{
        this.setState({
            userInput:e.target.value
        })
    }
    deleteCharHandler=(index)=>{
        const text=this.state.usrInput.split('');
        text.splice(index,1);
        const updateText=text.join('');
        this.setState({userInput:updateText})
    }




    render() {
        const charList=this.state.userInput.splice('').map((ch,index)=>{
       return   <Char  character={ch}
            key={index}
            clicked={()=>this.deleteCharHandler(index)} />
        });
        return (
            <div className="App2">
                <input type="text" onChange={this.inputChangeHandler}
                value={this.state.usrInput}/>
               <p>this.state.UserInput</p>
                <Validation inputLength={this.state.usrInput.length}/>
                {charList}
            </div>
        )
    }
}
export default App2;
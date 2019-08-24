import React, { Component } from 'react'
import Person from'./Person/Person'
export default class App extends Component {
  state={
    persons:[
      {name:"232323",age:30},
      {name:"232323",age:66},
      {name:"232323",age:44}

    ],
    otherState:"some other value"
  }
  switchNameHandler=(newname)=>{
    console.log("was cliked");
    this.setState({
      persons:[
        {name:'첫쨰',age:30},
        {name:newname , age:666}
      ]
    })
  }
  nameChangeHandler=(e)=>{
    this.setState({
      persons:[
        {name:'첫쨰',age:30},
        {name:e.target.value , age:666}
      ]
    })
  }
  render() {
    return (
      <div className="App">
        <Person name={this.state.persons[0].name} age={this.state.persons[0].age}
        click={this.switchNameHandler.bind(this,"자식한테 보내주기")}
        changed={this.nameChangeHandler}>qd</Person>
        <Person name={this.state.persons[1].name} age={this.state.persons[1].age}/>
        </div>
    )
  }
}

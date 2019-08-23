import React,{Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Person from './Person/Person';

// function App() {
//   return (
//     <div className="App">
//     <h1>리액트를 배우는중입니다.</h1>
//     </div>
//   );
// }


//class based
class App extends Component{
  state={
    persons:[
    {name:"232132",age:28},
    {name:'manu',age:30},
    {name:'2322',age:33330}
    ],
    otherState:"some other value"
  }
  switchNameHandler=(newName)=>{
    console.log("Was clicked");
    // 절대 이렇게 쓰지 말것.this.state.persons[0].name="하와아"
    this.setState({
      persons:[
        {name: "첫쨰",age:28},
        {name:newName,age:30},
        {name:'세번쨰',age:33330}
        ]

    })
  }

  nameChangedHandler=(event)=>{
    this.setState({
      persons:[
        {name: "newName",age:432423},
        {name: event.target.value,age:30},
        {name: 'ㅇㅇㅇ',age:33330}
        ]

    })
  }

  render(){
    return(
      <div className="App">
<h1>리액트를 확인</h1>
<Person name={this.state.persons[0].name} age={this.state.persons[0].age}
 click={this.switchNameHandler.bind(this,"자식한테 보내주자")}
 changed={this.nameChangedHandler}> 
 
  myhass</Person>
<Person name={this.state.persons[1].name} age={this.state.persons[1].age}/>
<Person name="manu" age="33"/>
<Person/>
              {/* 함수 ()를 쓰지말것 왜냐하면 함수실행되면 리렌더링되니까 */}
<button onClick={()=>this.switchNameHandler("요롷게 저렇게")}>눌려라</button>

      </div>
    )
// 이렇게도 가능한데.
// return React.createElement('div',null,"h1","여기야여기")
// return React.createElement('div',{className:"App"},React.createElement('h1',null,'맞아?'))

}
}


export default App;



//리액트 훅 이용
// import React, { useState } from 'react';
// import './App.css';
// import Person from './Person/Person';

// const app = props => {
//   const [personsState, setPersonsState] = useState({
//     persons: [
//       { name: 'Max', age: 28 },
//       { name: 'Manu', age: 29 },
//       { name: 'Stephanie', age: 26 }
//     ]
//   });

//   const [otherState, setOtherState] = useState('some other value');

//   console.log(personsState, otherState);

//   const switchNameHandler = () => {
//     // console.log('Was clicked!');
//     // DON'T DO THIS: this.state.persons[0].name = 'Maximilian';
//     setPersonsState({
//       persons: [
//         { name: 'Maximilian', age: 28 },
//         { name: 'Manu', age: 29 },
//         { name: 'Stephanie', age: 27 }
//       ]
//     });
//   };

//   return (
//     <div className="App">
//       <h1>Hi, I'm a React App</h1>
//       <p>This is really working!</p>
//       <button onClick={switchNameHandler}>Switch Name</button>
//       <Person
//         name={personsState.persons[0].name}
//         age={personsState.persons[0].age}
//       />
//       <Person
//         name={personsState.persons[1].name}
//         age={personsState.persons[1].age}
//       >
//         My Hobbies: Racing
//       </Person>
//       <Person
//         name={personsState.persons[2].name}
//         age={personsState.persons[2].age}
//       />
//     </div>
//   );
//   // return React.createElement('div', {className: 'App'}, React.createElement('h1', null, 'Does this work now?'));
// };

// export default app;

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
class App extends Component{
  render(){
    return(
      <div className="App">
<h1>리액트를 확인</h1>
<Person/>
<Person/>
<Person/>
<Person/>
<Person/>
<Person/>
<Person/>


      </div>
    )
// 이렇게도 가능한데.
// return React.createElement('div',null,"h1","여기야여기")
// return React.createElement('div',{className:"App"},React.createElement('h1',null,'맞아?'))

}
}

export default App;

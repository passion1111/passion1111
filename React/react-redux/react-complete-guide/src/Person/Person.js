import React from 'react';
import './Person.css';

const person= (props)=>{
    return (
    <div className="Person">
    
    {/* //   <h2>맞아? 내 이름{props.name}는 랜덤입니다 자바스크립트로~ {Math.floor(Math.random()*30)} 살이에요~</h2> */}
      <h2 onClick={props.click}>맞아? 내 이름{props.name}는 랜덤입니다 자바스크립트로~ {props.age} 살이에요~</h2>
      <p>{props.children}</p>
      <input type="text" onChange={props.changed}   />
 {/* //만약 클래스일경우 this.props이렇게 사용하면 됨. */}
    </div>
      )     
    }
    person.defaultProps={
        name:"아무개",
        age:"33"
    }
export default person;




















// import React from 'react';

// const person = ( props ) => {
//     return (
//         <div>
//             <p>I'm {props.name} and I am {props.age} years old!</p>
//             <p>{props.children}</p>
//         </div>
//     )
// };

// export default person;
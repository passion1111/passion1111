// //화살표 함수에는 없는것
// //함수이름 this argument 가 없다

// function(){


// }

// const myFun=()=>{//익명 함수로만 존재함 const myFun이렇게 해줘야함.
// // 애로우함수에는 자기만의 this가없다. 그래서 bind함수를 호출해서 this를 묶어주거나
// // aply나 call로 this를 일반 함수는 주입할수있는데 애로우함수는 불가능.
// }
{/* <button id="btn">Press</button>
const btn=document.getElementById('btn');
var myobj={
    count:3,
    setcount:function(){
        console.log(this.count);
    btn.addEventListener('click',function(){
        console.log(this);
    })
    }
};

myobj.setcount(); */}


//this가 없으니 프로토 타입이 없다

const myFun=function(){
    console.log(arguments);
}
function outter(){
    const myFun2=()=>{
            console.log(arguments);
        } //펑션 존재하지않음
        myFun2();
    }//arrow펑션에서의 arguments가 없기떄문에 
    // myfun2이 실행되는곳의 스코프를 들여다보게된다.
// const myFun2=()=>{
//     console.log(arguments);
// } //펑션 존재하지않음
// myFun(1,2,3,4);
outter(1,2,3,4);

const myFun3=(...args)=>{ //여러개가 있을건데 
    console.log(args);
}
myFun3(1,2,3,4,5,6,7,8);


//arrow펑션의 장점은 타이핑을 줄잀 ㅜ있다는것과 
// this의 바인드를 굳이 해주지 않아도 된다.이 기능들은 ES6
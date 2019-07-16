// // ajax('http://a.com/api/book'),(result)=>{

// // };



// function delay(sec,callback){
//     setTimeout(() => {
//        callback(new Date().toISOString()) ;
//     }, sec*1000);

// }

// console.log('start',new Date().toISOString());

// delay(1,(result) =>{
//      console.log(1,result);
     
//      delay(1,(result) =>{
//         // console.log(2,result);

//         delay(1,(result) =>{
//             console.log(3,result);
            
//     });
//     console.log(2,result); //딜레이 먼저 걸고 콘솔찍어도 같음 
//                         //그래서 디벅 ㅡ찍어보면 1찍히고 2찍히고 3찍힘.
//                         //근데 문제는 우리는 위에서 아래로 코드를 보게되는데
//                         // 중간에 console3부분떄문에 잘 읽히지않음 이문제를
//                         // 해결할려고 나온것이 promise
        
// });
// });
// console.log('hello');
// //비동기적으로 실행된다 그래서 start ->hello->딜레이 함수 순으로 실행된다
// //만약 딜레이가 따로따로 실행되면 비동기적으로 실행되기떄문에
// //딜레이가 같이 설정돼서 1초후에 1,2,3이 다 떠버린다.
// // 만약 그게 싫다면 delay안에 1초뒤 1초뒤 이렇게 설정하면 된다.

//-----------------------프로미스 시작--

// function delay(sec,callback){
//     setTimeout(() => {
//         callback(new Date().toISOString());
//     }, sec*1000);
// }

// delay(1,(result)=>{
//     console.log(1,result);
// });


// function delayP(sec){
//     return new Promise((resolve,rejct)=>{
        
//         setTimeout(() => {
//             resolve(new Date().toISOString());
//         }, sec*1000);

//     });
// }
// //delay를 호출하는 값은 then이라는값을 가지고있는 메소드 그것은
// // 프로미스의 인스턴스다. delayP
// delayP(1).then((result)=>{
//     console.log(1,result);

// });

//프로미스 예제 끝 ---------------------------------------//

function delayP(sec){
    return new Promise((resolve,rejct)=>{
        setTimeout(() => {
            resolve(new Date().toISOString());
        }, sec*1000);
    })
}

delayP(1).then((result)=>{ //첫번쨰 then이 resolve가 돼야 그다음 이어지는
                    // 
    console.log(1,result);
    return delayP(1);
}).then((result)=>{
    console.log(2,result);
    return delayP(1);
}).then((result)=>{
    console.log(3,result);
    return 'wow';
}).then((result)=>{
    console.log(result); //resolve를 하지않았기떄문에 delayP를 실행안했기떄문에
                    //시간 지연은 없고 wow만 리턴으로 받았기떄문에 wow만 바로 찍힌다.
});

//비동기
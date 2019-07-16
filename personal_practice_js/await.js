function delayP(sec){
return new Promise((resolve,reject)=>{
    setTimeout(()=>{
        resolve(new Date().toISOString());
    },sec*1000);
});
}
//--async 예제
//아래보면 3초뒤에 asyn가 찍힘
// async function myAsync2() {
//     await delayP(3);
//     return 'async';
// }
// myAsync2().then((result)=>{
//     console.log(result);
// });
//async2 예제

// async function myAsync2() {
//      const time=  await delayP(3);  //이런식으로  delayP의 결과값을 time으로 집어넣을수 있음.
//      console.log(time);
//         return 'async';
//     }
//     myAsync2().then((result)=>{
//         console.log(result);
//     });
//-------------------------------


// function myFunc(){
//     return 'func';
// }


//--------------async예제 3 아직 완성되지않음.
async function myAsync2() {
     const time=  await delayP(3);  //이런식으로  delayP의 결과값을 time으로 집어넣을수 있음.
     console.log(time);
        return 'async';
    }
    myAsync2().then((result)=>{
        console.log(result);
    });










// async function myAsync(){
//     delayP(0).then((time)=>{
//         console.log(time+"여긴 그냥임");
//     });
//     // console.log("두번찍히나?");//이해완료 
//     // await...      //await은 promise가 resolve돼서 결과값이 넘어올떄까지 기달린다.
//     return 'async'
// }
// //어싱크에서는 리졸브로 넘기게되는값은 결국 리턴하면 되고
// // 리젝을 해야한다면 에러를 throw해야함. 

// myAsync().then((result)=>{//여기서 result는 async 리턴값
//  console.log(result);
// });
// console.log(myFunc());
// // console.log(myAsync());


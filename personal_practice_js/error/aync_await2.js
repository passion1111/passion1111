// function wait(sec){
//     return new Promise(resolve=>{
//         setTimeout(() => {
//             resolve('done');
//         }, sec*1000);
//     });
// }

// async function myAsyncFun(){
//     console.log(new Date());
//     wait(1);
//     console.log(new Date());
// }
// const result=myAsyncFun();

//-- resolve된 경우 
function wait(sec){
    return new Promise((resolve,reject)=>{
        setTimeout(() => {
            reject('wait error');
        }, sec*1000);
    });
}

async function myAsyncFun(){
    console.log(new Date());
    try {
        await wait(1);  //여기에 catch해도 아무 이상없음.
        
    } catch (error) {
        console.error(error);
    }
   console.log(new Date());
}
const result =myAsyncFun();
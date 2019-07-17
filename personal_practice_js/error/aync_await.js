async function myAsyncfun(){
//하나만 reject하고싶은경우 
    // return 'done';
// 2개다 rejected하고싶은경우
    throw 'myAsyncError';
}

function myPromiseFun(){
    return new Promise((resolve,reject)=>{
        // resolve('done');
        reject('myerror');
    });
}
const result=myAsyncfun().catch(e=>{
    console.log(e);
});
// console.log(result);

const result2=myPromiseFun().catch(e=>{
    console.log(e);
});
// console.log(result2);
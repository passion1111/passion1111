function delayP(sec){
return new Promise((resolve,reject)=>{
    setTimeout(()=>{
        resolve(new Date().toISOString());
    },sec*1000);
});
}

function myFunc(){
    return 'func';
}

async function myAsync(){
    delayP(3).then((time)=>{
        console.log(time+"여긴 그냥임");
    });
    
    // await...      //await은 promise가 resolve돼서 결과값이 넘어올떄까지 기달린다.
    return 'async'
}
//어싱크에서는 리졸브로 넘기게되는값은 결국 리턴하면 되고
// 리젝을 해야한다면 에러를 throw해야함. 

myAsync().then((result)=>{//여기서 result는 async 리턴값
 console.log(result);
});
console.log(myFunc());
console.log(myAsync());


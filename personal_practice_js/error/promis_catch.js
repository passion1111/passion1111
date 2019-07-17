function wait(sec) {
    return new Promise((resolve,reject)=>{
        setTimeout(() => {
            reject('error');
        }, sec*1000);
    });
}
// try {
//     wait(3);
    
// } catch (error) {
//     console.error(error);
// }


//--------
// wait(1).catch(e=>{
//     console.log('1st catch',e);
// });
//프로미스의 체인은 첫번쨰의 promise랑 두번쨰의 promise랑은 다른 객체임.
// wait의 프로미스는 캣치자체가 제대로 됐는지에 대한 프로미스임.
// 그래서 wait.cath.chat형태로 가면 위에있는 catch가 제대로 돌아가면
// 실행이 안되게 됨.
//해결법
//------------------
// wait(0)
//     .catch(e=>{
//         console.log('1st catch',e);
//         throw e;
//     })
//     .catch(e=>{
//         console.log('2st catch',e);
//     });

    //--위에있는 이용방법말고 한 방법이 더 있는데 그것은 then을 이용한방법
    wait(0)
    .then(()=>{
        console.log('done!')
    },e=>{  //리젝트로 두번쨰가 실행됐으니 .catch는 실행되지않음.
            // onfullfield상태에서는 즉 then이 resolve되면. 
            // then에있는것들이 실행됨. 
        console.log('1nd catch in then',e);
    })       
    .catch(e=>{
        console.log()
    })
const axios=require('axios');
const functions= {
    add: (num1,num2) =>num1+num2,
    isnull:()=> null ,
    checkValue:(x)=>x,
    createuser: ()=>{
        const user={firstname:'brad'}
        user['lastName']='traversy';
        return user;
    }
    ,fetchUser:()=>axios.get('https://jsonplaceholder.typicode.com/users/1').then(res=>res.data).catch(err=>'error')
};



module.exports=functions;
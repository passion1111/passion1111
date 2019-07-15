const functions= {
    add: (num1,num2) =>num1+num2,
    isnull:()=> null ,
    checkValue:(x)=>x,
    createuser: ()=>{
        const user={firstname:'brad'}
        user['lastName']='traversy';
        return user;
    }
};



module.exports=functions;
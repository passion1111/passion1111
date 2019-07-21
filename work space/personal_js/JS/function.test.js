const functions=require('./jest');

// beforeEach(()=>initDatabase());
// afterEach(()=>closeDatabase());

// const initDatabase=()=>console.log('database 초기화중');
// const closeDatabase()=>console.log('database 닫음');
//안됨 이유 찾아보기
const namecheck=()=>console.log('checking name..');

describe('checking name', () => {
    beforeEach(()=>namecheck());
    test('유저는 제프다',()=>{
        const user='제프';
        expect(user).toBe('제프');
    });

});


test('adds 2+2 to equals 4',()=>{
    expect(functions.add(2,2)).toBe(4);
});

test('adds 2+2 to not equals 5',()=>{
    expect(functions.add(2,2)).not.toBe(5);
});

test('should be null',()=>{
    expect(functions.isnull()).toBeNull();
});

test('should be faly',()=>{ 
    
    expect(functions.checkValue(null)).toBeFalsy();

    
});


//toEqual
test('user should be brad traversy object',()=>{
    expect(functions.createuser()).toEqual({firstname:'brad',lastName:'traversy'
});
});

//less than and  greater than
test('should be under 1600',()=>{
    const load1=800;
    const load2=800;
    expect(load1+load2).toBeLessThanOrEqual(1600);
});

//Regex
test('there is no i in team',()=>{
    expect('team').not.toMatch(/I/i);
});

//Arrays
test('Admin should be in usernames',()=>{
    usernames=['john','kare','admin'];
    expect(usernames).toContain('admin');
});

// //working with async data 사용안될수도 있음
test('user fetched name should be leanne graham',async()=>{
    // expect.assertions(1); //없어도 pass
    const data= await functions.fetchUser();
        expect(data.name).toEqual('Leanne Graham');
});  
//promise
test('user fetched name should be leanne graham',()=>{
    // expect.assertions(1); //없어도 pass
    return functions.fetchUser().then(data=>{
        expect(data.name).toEqual('Leanne Graham');
    });
});  
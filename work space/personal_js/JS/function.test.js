const functions=require('./jest');

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
    expect('teamI').not.toMatch(/I/i);
});
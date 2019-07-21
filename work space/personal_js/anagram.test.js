const isAnagram=require('./anagram');

test('isAnagram function  exist',()=>{
    expect(typeof isAnagram).toEqual('function');
});

test('cinema is an anagram of "iceman ',()=>{
    expect(isAnagram('cinema','iceman')).toBeTruthy();
});


test('Dormitory is an anagram of "diry romm##"',()=>{
    expect(isAnagram('Dormitory','dirty room##')).toBeTruthy();
});

test('Hello is not an anagram of "Aloha"',()=>{
    expect(isAnagram('Hello','Aloha')).toBeTruthy();
});

//말그대로 아나그램 두 글자가 같은지 다른지 비교.
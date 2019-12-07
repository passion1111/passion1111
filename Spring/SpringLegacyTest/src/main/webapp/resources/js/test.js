function outerFunction () {
  const outer = 'test'
  function innerFunction() {
    return outer;
  }
  return innerFunction
}

console.log(1)
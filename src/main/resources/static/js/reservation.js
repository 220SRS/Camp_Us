function count1(type)  {
  const resultElement = document.getElementById('result1');

  let number = resultElement.innerText;

  if(type === 'plus') {
    number = parseInt(number) + 1;
  }else if(type === 'minus')  {
    number = parseInt(number) - 1;
  }

  resultElement.innerText = number;
}

function count2(type)  {
  const resultElement = document.getElementById('result2');

  let number = resultElement.innerText;

  if(type === 'plus') {
    number = parseInt(number) + 1;
  }else if(type === 'minus')  {
    number = parseInt(number) - 1;
  }

  resultElement.innerText = number;
}

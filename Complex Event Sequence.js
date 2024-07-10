document.querySelector(".new-todo").value="hello";
document.querySelector(".new-todo").dispatchEvent(new Event('change', { 'bubbles': true }));
document.querySelector('ul.todo-list > li:nth-child(2) > div > label').dblclick()
document.querySelector('ul.todo-list > li:nth-child(2) > div > label').dispatchEvent(new Event('dblclick', { 'bubbles': true }));
document.querySelector(‘ul.todo-list > li:nth-child(2) .edit’) .value="amended"
document.querySelector(‘ul.todo-list > li:nth-child(2) .edit’) .dispatchEvent(new Event(‘blur’))

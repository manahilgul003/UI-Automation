Math.floor(Math.random()*10)
for(var prop in autoTodo){
  if(typeof autoTodo[prop] == 'function'){console.log(prop)}
}
var rando = new function(){

}
function getRandomInt(x){
    return Math.floor(Math.random() * x);
}
function getRandomItemIndex(){
    max = document.querySelectorAll("ul.todo-list li").length;
    if(max===0){
        console.log("no items to choose from");
        return 0;
    }
    x = getRandomInt(max)+1;
    return x;
}
this.selectRandomItem = function () {    
    x = getRandomItemIndex();
    if(x>0){    
        console.log("select item " + x);
        autoTodo.selectItemX(x);
    }
}
this.toggleAll = Toggle All");
    console.log("toggle all");
    autoTodo.toggleAll();
}

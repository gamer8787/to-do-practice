function addTODO(json){
    json.forEach(element => addElement(element));   
} 
let addElement = element =>{
    var taskList = document.querySelectorAll(`.${element.type}`);
    subject = taskList[taskList.length-1];
    var buttonShape = "→";
    if(element.type==="DONE"){
        buttonShape = "X";
    }
    var button = `<button id = ${element.id} value = ${element.type} style = "font-size: 20px; float:right;
        margin : 9px 9px 0 0;" onclick="ajax(this)"  >${buttonShape}</button>`;  
    var insertTag = `<li class = \"${element.type} content\"><span class = \"title\"> `
        + `${element.title} ${button}</span><br><span>등록날짜:${element.regDate} ${element.name}, `
        + `우선순위 ${element.sequence}</span></li>`;
    subject.insertAdjacentHTML("afterend",insertTag);
             };             
function ajax(self) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        self.parentElement.parentElement.remove();
        console.log(this.responseText);
        console.log(typeof(this.responseText));
        var element = JSON.parse(this.responseText);
        if (element===null){
            return;
        }
        addElement(element);
    });    
    oReq.open("GET", `http://localhost:8080/Todo/todotype?id=${self.id}&type=${self.value}`);//parameter를 붙여서 보낼수있음. 
    oReq.send();
    }

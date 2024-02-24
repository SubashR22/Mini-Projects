let userinput=document.getElementById("d1");
let result=document.getElementById("result");
function myage(){
    
    let birthdate=new Date(userinput.value);
    let d1=birthdate.getDate();
    let m1=birthdate.getMonth()+1;
    let y1=birthdate.getFullYear();
    let today=new Date();
    let d2=today.getDate();
    let m2=today.getMonth()+1;
    let y2=today.getFullYear();
    let d3,m3,y3;
    if(m2<m1){
        let year=y2-1;
        y3=year-y1;
        
}
 m3=12+(m2)-m1;
 d3=d2-d1;
result.innerHTML=`You are <span>${y3}</span> years,<span>${m3}</span> months,<span>${d3}</span> days old.`;

}
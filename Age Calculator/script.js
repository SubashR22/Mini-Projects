let userinput = document.getElementById("d1");
let result = document.getElementById("result");

function myage() {
    if (!userinput.value) {
        result.innerHTML = `<span style="color: red;">Please enter the date.</span>`;
        return;
    }
    let birthdate = new Date(userinput.value);
    let d1 = birthdate.getDate();
    let m1 = birthdate.getMonth() + 1; 
    let y1 = birthdate.getFullYear();
    
    let today = new Date();
    let d2 = today.getDate();
    let m2 = today.getMonth() + 1;
    let y2 = today.getFullYear();
    
    let d3, m3, y3;
    
    y3 = y2 - y1;
    m3 = m2 - m1;
    d3 = d2 - d1;
    
    if (d3 < 0) {
        m3 -= 1;
        d3 += new Date(y2, m2 - 1, 0).getDate(); 
    }
    
    if (m3 < 0) {
        y3 -= 1;
        m3 += 12;
    }
    
    result.innerHTML = `You are <span>${y3}</span> years, <span>${m3}</span> months, <span>${d3}</span> days old.`;
}

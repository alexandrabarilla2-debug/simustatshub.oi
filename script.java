/* ========================= */
/* BAR GRAPH (Unlimited digits allowed) */
/* ========================= */

let barLabels = [];
let barValues = [];

const barChart = new Chart(document.getElementById("barChart"), {
type: 'bar',
data: {
labels: barLabels,
datasets: [{
label: 'Data',
data: barValues,
backgroundColor: 'rgba(52,152,219,0.7)'
}]
}
});

function addBarData(){
let label = document.getElementById("labelInput").value;
let value = parseFloat(document.getElementById("valueInput").value);

if(label !== "" && !isNaN(value)){
barLabels.push(label);
barValues.push(value);
barChart.update();
}
}

/* ========================= */
/* COIN WITH PERCENTAGE */
/* ========================= */

let heads = 0;
let tails = 0;

function tossCoin(){
let coin = document.getElementById("coin");

coin.style.transform = "rotateY(720deg)";

setTimeout(()=>{
let result = Math.random() < 0.5 ? "HEAD" : "TAIL";
coin.innerHTML = result;

if(result === "HEAD") heads++;
else tails++;

let total = heads + tails;

let headPercent = ((heads / total) * 100).toFixed(0);
let tailPercent = ((tails / total) * 100).toFixed(0);

document.getElementById("percentDisplay").innerText =
"Heads: " + headPercent + "% | Tails: " + tailPercent + "%";

coin.style.transform = "rotateY(0deg)";

},1000);
}

/* ========================= */
/* DICE THROW */
/* ========================= */

function rollDice(){
let dice = document.getElementById("dice");

dice.style.transform = "rotate(360deg)";

setTimeout(()=>{

dice.innerHTML = "";

let num = Math.floor(Math.random()*6) + 1;

showDice(num);

dice.style.transform = "rotate(0deg)";

},600);
}

function showDice(num){

let dice = document.getElementById("dice");

let positions = {
1:[4],
2:[0,8],
3:[0,4,8],
4:[0,2,6,8],
5:[0,2,4,6,8],
6:[0,2,3,5,6,8]
};

for(let i=0;i<9;i++){

let dot = document.createElement("div");

dot.className = "dot";

if(!positions[num].includes(i)){
dot.classList.add("hidden");
}

dice.appendChild(dot);

}

}

/* ========================= */
/* SIMPLE LINEAR REGRESSION */
/* ========================= */

let points = [];

const scatterChart = new Chart(document.getElementById("scatterChart"),{
type:'scatter',
data:{
datasets:[{
label:'Points',
data:points,
backgroundColor:'red'
}]
}
});

function addPoint(){

let x = parseFloat(document.getElementById("xVal").value);
let y = parseFloat(document.getElementById("yVal").value);

if(!isNaN(x) && !isNaN(y)){

points.push({x:x,y:y});

scatterChart.update();

}

}

/* ========================= */
/* Z TEST */
/* ========================= */

function calculateZ(){

let mean = parseFloat(document.getElementById("mean").value);
let popMean = parseFloat(document.getElementById("popMean").value);
let sd = parseFloat(document.getElementById("sd").value);
let n = parseFloat(document.getElementById("n").value);

let z = (mean - popMean) / (sd / Math.sqrt(n));

document.getElementById("zResult").innerText = "Z-score: " + z.toFixed(3);

}

/* ========================= */
/* CORRELATION */
/* ========================= */

let relX = [];
let relY = [];

function addRel(){

let x = parseFloat(document.getElementById("xRel").value);
let y = parseFloat(document.getElementById("yRel").value);

if(!isNaN(x) && !isNaN(y)){

relX.push(x);
relY.push(y);

let n = relX.length;

let sumX = relX.reduce((a,b)=>a+b,0);
let sumY = relY.reduce((a,b)=>a+b,0);

let sumXY = relX.reduce((a,b,i)=>a + b * relY[i],0);

let sumX2 = relX.reduce((a,b)=>a + b*b,0);
let sumY2 = relY.reduce((a,b)=>a + b*b,0);

let r = (n * sumXY - sumX * sumY) /
Math.sqrt((n * sumX2 - sumX**2) * (n * sumY2 - sumY**2));

document.getElementById("corrResult").innerText =
"Correlation (r): " + r.toFixed(3);

}

}

/* ========================= */
/* T TEST */
/* ========================= */

let group1 = [];
let group2 = [];

function addGroups(){

let g1 = parseFloat(document.getElementById("g1").value);
let g2 = parseFloat(document.getElementById("g2").value);

if(!isNaN(g1) && !isNaN(g2)){

group1.push(g1);
group2.push(g2);

}

}

function computeT(){

let mean1 = group1.reduce((a,b)=>a+b,0)/group1.length;
let mean2 = group2.reduce((a,b)=>a+b,0)/group2.length;

let var1 = group1.reduce((a,b)=>a + (b-mean1)**2,0)/(group1.length-1);
let var2 = group2.reduce((a,b)=>a + (b-mean2)**2,0)/(group2.length-1);

let t = (mean1 - mean2) /
Math.sqrt(var1/group1.length + var2/group2.length);

document.getElementById("tResult").innerText =
"T-value: " + t.toFixed(3);

}
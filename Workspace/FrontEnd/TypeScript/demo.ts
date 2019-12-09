let myName: String = 'Sumedh';
// myName = 1234; error - we cannot change the datatype


let company; //implicitly considered as any 
company = 1234;
company = 'capg';
company = true;


//union
let age: string | number;
age = 12;
age = 'twelve';
//age = true; error other than no. and string

//tuple
let details:[string, number, number] = ['Sumedh',45,78];
 //array
 let mobiles = ['Samsung' , 124,true];//it can store any datatype 
let mobile:string[] = ['samsung','india'];

function add(a: number,b: number):number{
    return a+b;
}

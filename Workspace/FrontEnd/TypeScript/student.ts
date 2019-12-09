class student{
constructor(
    public name:String,
    public age: number,
    public marks: number,
    public degree ?:string
    )
    {

    }

    // printDetails(){
    //     console.log(`Name id ${this.name} age is ${this.age} and marks are ${this.marks}`);
    // }

}

let student1 = new student('Priya',99,99,'BE');
console.log(student1);
//student1.printDetails();

let student2: student = {
    name: 'Deepak',
    age: 104,
    marks: 69,
    degree: 'BE',
   }

   console.log(student2);

   let students:student[] = [
       new student('Surbhut',299,12),
       {
        name: 'Deepak',
        age: 104,
        marks: 69,
        degree: 'BE'
       },
       student1,
       student2
    ];

for (let student of students)
{
    console.log(student);
}

class Graduate extends student
{
  constructor(
     name:String,
     age: number,
     marks: number,
     degree ?:string
  )  
  {
      super(name,age,marks)
  }
}
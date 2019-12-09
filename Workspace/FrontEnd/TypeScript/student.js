var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var student = /** @class */ (function () {
    function student(name, age, marks, degree) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.degree = degree;
    }
    return student;
}());
var student1 = new student('Priya', 99, 99, 'BE');
console.log(student1);
//student1.printDetails();
var student2 = {
    name: 'Deepak',
    age: 104,
    marks: 69,
    degree: 'BE'
};
console.log(student2);
var students = [
    new student('Surbhut', 299, 12),
    {
        name: 'Deepak',
        age: 104,
        marks: 69,
        degree: 'BE'
    },
    student1,
    student2
];
for (var _i = 0, students_1 = students; _i < students_1.length; _i++) {
    var student_1 = students_1[_i];
    console.log(student_1);
}
var Graduate = /** @class */ (function (_super) {
    __extends(Graduate, _super);
    function Graduate(name, age, marks, degree) {
        return _super.call(this, name, age, marks) || this;
    }
    return Graduate;
}(student));

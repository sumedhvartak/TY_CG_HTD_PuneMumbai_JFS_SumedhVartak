import { Component, OnInit } from '@angular/core';
import { Car } from '../car';

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {
  cars: Car[] =[
    {
      brand:'Maruthi',
      imgURL:'https://cdn.pixabay.com/photo/2016/02/13/13/11/cuba-1197800__340.jpg',
      model:'1945',
      specs:'The Maruti Swift has 1 Diesel Engine and 1 Petrol Engine on offer. The Diesel engine is 1248 cc while the Petrol engine is 1197 cc. Depending upon the variant and fuel type the Swift has a mileage of 22.0 to 28.4 kmpl. The Swift is a 5 seater Hatchback and has a length of 3840mm.'
    },
    {
      brand:'Suzuki',
      imgURL:'https://cdn.pixabay.com/photo/2015/05/28/23/12/auto-788747__340.jpg',
      model:'1885',
      specs:'The Suzuki has 1 kerosine Engine and 1 Diesel Engine on offer. The Diesel engine is 1248 cc while the kersine engine is 466 cc. Depending upon the variant and fuel type the Swift has a mileage of 22.0 to 28.4 kmpl. The Suzuki is a 5 seater Hatchback and has a length of 3840mm.'
    },
    {
      brand:'Lamborgini',
      imgURL:'https://cdn.pixabay.com/photo/2016/04/01/12/16/car-1300629__340.png',
      model:'2010',
      specs:'The Lamborghini Swift has 1 Lamborghini Engine and 1 Lamborghini Engine on offer. The Diesel engine is 5000 cc while the Petrol engine is 5000 cc. Depending upon the variant and fuel type the Swift has a mileage of 3.0 to 5.0 kmpl. The Swift is a 5 seater Hatchback and has a length of 5000.'
    },
    {
      brand:'BMW',
      imgURL:'https://cdn.pixabay.com/photo/2015/05/15/14/46/bmw-768688__340.jpg',
      model:'2010',
      specs:'BMW cars price starts at Rs. 35.20 lakh for the cheapest car X1 and goes up to Rs. 2.43 crore for the top model BMW 7 Series. BMW offers 14 new car models in India. X1 (Rs. 35.20 lakh), Z4 (Rs. 64.90 lakh) and 3 Series GT (Rs. 47.70 lakh) are among the popular cars from BMW.'
    },
    {
      brand:'Lamborgini Aventador',
      imgURL:'https://cdn.pixabay.com/photo/2019/04/14/14/21/car-4126869__340.jpg',
      model:'2015',
      specs:'The Petrol engine is 6498 cc. It is available with the Automatic transmission. Depending upon the variant and fuel type the Aventador has a mileage of 5.0 to 7.69 kmpl. The Aventador is a 2 seater Coupe and has a length of 4843 mm, width of 2273 mm and a wheelbase of 2700mm.'
    },
    {
      brand:'Audi A3',
      imgURL:'https://cdn.pixabay.com/photo/2016/12/07/15/32/audi-1889699__340.jpg',
      model:'2010',
      specs:'Audi A3 Variants & Price: The Audi A3 is available in two variants: Premium Plus and Technology, priced from Rs 28.99 lakh to 31.99 lakh (ex-showroom pan-India). Audi A3 Engines: The A3 comes with a 1.4-litre TFSI turbocharged petrol engine that makes 150PS of power and 250Nm.'
    },
    {
      brand:'Ferrari',
      imgURL:'https://cdn.pixabay.com/photo/2017/11/09/01/49/ferrari-458-spider-2932191__340.jpg',
      model:'1885',
      specs:'The Ferrari 812 Superfast, replacement for the F12berlinetta, is one of the few exotic cars still equipped with a V12. The front-mounted 6.5L engine produces 800 horsepower and 530 lb. ft of torque and barely weighs 1600 kilos. Performance is mind-blowing (0-100 km/h in 2.9 seconds) and the engine sound is exquisite.'
    },
    {
      brand:'Bugatti La Voiture Noire',
      imgURL:'https://cdn.pixabay.com/photo/2019/02/04/10/46/bugatti-3974383__340.jpg',
      model:'2012',
      specs:'The Bugatti La Voiture Noire is a one-off supercar based on the Chiron. Unveiled at the 2019 Geneva Motor Show, it joins the Divo as a derivative from the already famous Chiron hypercar. The La Voiture Noire is a modern reinterpretation of the Type 57 SC Atlantic from the 1930s.'
    },
    {
      brand:'Mercedes Benz',
      imgURL:'https://cdn.pixabay.com/photo/2016/07/09/21/47/car-1506922__340.jpg',
      model:'2015',
      specs:'The Mercedes-Benz E-Class has 2 Diesel Engine and 2 Petrol Engine on offer. ... Depending upon the variant and fuel type the E-Class has a mileage of 10.98 to 18.0 kmpl. The E-Class is a 5 seater Sedan and has a length of 4988mm, width of 1907mm and a wheelbase of 2939mm.'
    },
    {
      brand:'Audi RS3',
      imgURL:'https://cdn.pixabay.com/photo/2016/12/07/21/50/audi-1890494__340.jpg',
      model:'2017',
      specs:'Specs overview. Engine. 2.5-liter five-cylinder. Horsepower. 394. Acceleration (0—60 mph) 3.9 seconds. Torque (lb-ft @ rpm) 354. Transmission. Seven-speed S tronic® dual-clutch automatic transmission and quattro® all-wheel drive. Top speed. 155 mph 7. Valvetrain. 20-valve DOHC with Audi valvelift. Combined mpg.'
    }
  ];
selectedCar : Car = this.cars[0];
  constructor() { }
  selectCar(car){
    this.selectedCar = car;
  }
  ngOnInit() {
  }

}

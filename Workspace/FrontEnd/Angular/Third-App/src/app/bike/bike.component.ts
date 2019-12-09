import { Component, OnInit } from '@angular/core';
import { Bike } from '../bike';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-bike',
  templateUrl: './bike.component.html',
  styleUrls: ['./bike.component.css']
})
export class BikeComponent implements OnInit {
  bikes: Bike[]=[
    {
      brand:'BMW',
      imgURL:'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg',
      model:'1945',
      specs:'The Maruti Swift has 1 Diesel Engine and 1 Petrol Engine on offer. The Diesel engine is 1248 cc while the Petrol engine is 1197 cc. Depending upon the variant and fuel type the Swift has a mileage of 22.0 to 28.4 kmpl. The Swift is a 5 seater Hatchback and has a length of 3840mm.'
    },
    {
      brand:'Suzuki',
      imgURL:'https://cdn.pixabay.com/photo/2014/04/23/20/34/dirt-bike-330815__340.jpg',
      model:'1885',
      specs:'The Suzuki has 1 kerosine Engine and 1 Diesel Engine on offer. The Diesel engine is 1248 cc while the kersine engine is 466 cc. Depending upon the variant and fuel type the Swift has a mileage of 22.0 to 28.4 kmpl. The Suzuki is a 5 seater Hatchback and has a length of 3840mm.'
    },
    {
      brand:'Kawasaki',
      imgURL:'https://cdn.pixabay.com/photo/2015/09/08/21/02/superbike-930715__340.jpg',
      model:'2010',
      specs:'The Lamborghini Swift has 1 Lamborghini Engine and 1 Lamborghini Engine on offer. The Diesel engine is 5000 cc while the Petrol engine is 5000 cc. Depending upon the variant and fuel type the Swift has a mileage of 3.0 to 5.0 kmpl. The Swift is a 5 seater Hatchback and has a length of 5000.'
    },
    {
      brand:'RE Inspector',
      imgURL:'https://cdn.pixabay.com/photo/2014/12/16/03/37/motor-cycle-569865__340.jpg',
      model:'2017',
      specs:'BMW cars price starts at Rs. 35.20 lakh for the cheapest car X1 and goes up to Rs. 2.43 crore for the top model BMW 7 Series. BMW offers 14 new car models in India. X1 (Rs. 35.20 lakh), Z4 (Rs. 64.90 lakh) and 3 Series GT (Rs. 47.70 lakh) are among the popular cars from BMW.'
    },
    {
      brand:'Bugati',
      imgURL:'https://cdn.pixabay.com/photo/2016/01/19/16/46/motorcycle-1149389__340.jpg',
      model:'2015',
      specs:'The Petrol engine is 6498 cc. It is available with the Automatic transmission. Depending upon the variant and fuel type the Aventador has a mileage of 5.0 to 7.69 kmpl. The Aventador is a 2 seater Coupe and has a length of 4843 mm, width of 2273 mm and a wheelbase of 2700mm.'
    },
    {
      brand:'Audi',
      imgURL:'https://cdn.pixabay.com/photo/2016/03/27/17/59/vintage-1283299__340.jpg',
      model:'1998',
      specs:'Audi A3 Variants & Price: The Audi A3 is available in two variants: Premium Plus and Technology, priced from Rs 28.99 lakh to 31.99 lakh (ex-showroom pan-India). Audi A3 Engines: The A3 comes with a 1.4-litre TFSI turbocharged petrol engine that makes 150PS of power and 250Nm.'
    },
    {
      brand:'RE Classics',
      imgURL:'https://cdn.pixabay.com/photo/2015/08/27/09/06/bike-909690__340.jpg',
      model:'2000',
      specs:'The Ferrari 812 Superfast, replacement for the F12berlinetta, is one of the few exotic cars still equipped with a V12. The front-mounted 6.5L engine produces 800 horsepower and 530 lb. ft of torque and barely weighs 1600 kilos. Performance is mind-blowing (0-100 km/h in 2.9 seconds) and the engine sound is exquisite.'
    },
    {
      brand:'Bajaj',
      imgURL:'https://cdn.pixabay.com/photo/2015/11/07/11/18/moped-1031006__340.jpg',
      model:'2010',
      specs:'The Bugatti La Voiture Noire is a one-off supercar based on the Chiron. Unveiled at the 2019 Geneva Motor Show, it joins the Divo as a derivative from the already famous Chiron hypercar. The La Voiture Noire is a modern reinterpretation of the Type 57 SC Atlantic from the 1930s.'
    },
    {
      brand:'Suzuki Gixxer sf',
      imgURL:'https://cdn.pixabay.com/photo/2017/07/01/03/47/bike-2460493__340.jpg',
      model:'2016',
      specs:'DescriptionThe Suzuki Gixxer SF is a 154.9 cc fully faired motorcycle from Suzuki. The bike was launched in 2014. Its design is inspired by the GSX-R1000, and the mighty Suzuki Hayabuza. Infact the fairing of the motorcycle is tested in the same tunnel that they tests GSXR and Hayabuza'
    },
    
  ];
  selectedBike: Bike = this.bikes[0];
  constructor() { }

  selectBike(bike){
    this.selectedBike = bike;
  }

  ngOnInit() {
  }

}

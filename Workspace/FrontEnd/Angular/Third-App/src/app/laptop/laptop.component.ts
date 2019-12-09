import { Component, OnInit } from '@angular/core';
import { Laptop } from '../laptop';

@Component({
  selector: 'app-laptop',
  templateUrl: './laptop.component.html',
  styleUrls: ['./laptop.component.css']
})
export class LaptopComponent implements OnInit {
  laptops: Laptop[] =[
    {
      name:'ASUS ROG Gaming',
      imgURL:'https://cdn.pixabay.com/photo/2014/09/27/13/44/notebook-463485__340.jpg',
      price:53000,
      info:'ASUS Laptop X407UB. Processor. Intel® Core™ i3 6006U Processor, 2 GHz (3 M Cache) Operating System. Windows 10 Pro - ASUS recommends Windows 10 Pro. Memory. DDR4 2400MHz SDRAM, 1 x SO-DIMM socket , up to 8 GB SDRAM. Display. 14.0" (16:9) LED-backlit HD (1366x768) 60Hz Anti-Glare Panel with 45% NTSC. Graphic Storage.'
    },
    {
      name:'HP Pavilion',
      imgURL:'https://cdn.pixabay.com/photo/2017/02/25/02/32/b-w-2096808__340.jpg',
      price:40000,
      info:'HP Pavilion x360 With Alexa In-built. Freedom To Do More w/ Power Of Your Voice. Shop Now! Accidental Protection. Protegent Antivirus. Additional Warranty. Theft Insurance. Models: HP Pavilion x360 14, HP Gaming Pavilion - 15, OMEN by HP 15, HP Notebook - 15.'
    },
    {
      name:'Dell Vostro',
      imgURL:'https://cdn.pixabay.com/photo/2017/08/10/07/32/dell-2619501__340.jpg',
      price:34000,
      info:'Dell 15 7000 Crafted From Brushed Aluminium. Laptop W/ Intel Core. Shop Today! Sennheiser Headset @ 299. Get 3Yr Premium Support. Cash off on MS Office. Get Warranty Worth@₹3999. Amenities: Dell Power Companion, Dell Bluetooth Mouse.'
    },
    {
      name:'Apple Mackbox Air',
      imgURL:'https://cdn.pixabay.com/photo/2014/05/02/21/49/home-office-336373__340.jpg',
      price:59880,
      info:'2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory. 2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory.'
    },
    {
      name:'Toshiba',
      imgURL:'https://d2pa5gi5n2e1an.cloudfront.net/global/images/product/laptops/TOSHIBA_Satellite_Pro_L850/TOSHIBA_Satellite_Pro_L850_L_1.jpg',
      price:35600,
      info:'This item 2015 Toshiba Satellite 15.6-inch Laptop- 5th Gen Intel Core i7-5500U Processor 3.0GHz, 4MB Cache, 8GB Memory, 1TB HDD, HDMI, Bluetooth, Webcam, WIFI, AMD R7 M260, Windows 8.1/Windows 10.'
    },
    {
      name:'Acer',
      imgURL:'https://cdn.pixabay.com/photo/2015/05/31/10/51/acer-791027__340.jpg',
      price:29000,
      info:'Comes W/ Infinity Edge IPS Display. Laptops W/ Intel® Core™ Processor, Buy Now! Cash off on MS Office. Get 3Yr Hardware Warranty. Get 3Yr Premium Support. Amenities: Dell Pro Backpack, Dell Bluetooth Mouse, Dell Professional Headset, Accidental Damage Service.'
    },
    {
      name:'MicroSoft Surface',
      imgURL:'https://cdn.pixabay.com/photo/2019/06/15/09/26/laptop-4275110__340.jpg',
      price:70990,
      info:'CPU: 2.4GHz Intel Core i5-6300U (dual-core, 3MB cache, up to 3GHz with Turbo Boost) Graphics: Intel HD Graphics 520. RAM: 8GB LPDDR3. Screen: 12.3-inch, 2,736 x 1,824 PixelSense display (Contrast ratio: 1,300:1, 100% sRGB color, 10-point multi-touch, 3:2 aspect ratio) Storage: 256GB SSD (PCIe 3.0)'
    }
  ];

  selectedlaptop: Laptop = this.laptops[0];
  constructor() { }
  selectlaptop(laptop)
  {
    this.selectedlaptop = laptop;
  }
  ngOnInit() {
  }

}

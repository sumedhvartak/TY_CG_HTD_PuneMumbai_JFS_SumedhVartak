import { Component, OnInit } from '@angular/core';
import { Mobile } from '../mobile';

@Component({
  selector: 'app-mobile',
  templateUrl: './mobile.component.html',
  styleUrls: ['./mobile.component.css']
})
export class MobileComponent implements OnInit {
mobiles: Mobile[] = [
  {
    name:'ASUS Zenfone 5',
    imgURL:'https://cdn.pixabay.com/photo/2016/11/10/16/18/android-1814600__340.jpg',
    price:149999,
    info:'ASUS Mobile X407UB. Processor. Intel® Core™ i3 6006U Processor, 2 GHz (3 M Cache) Operating System. Windows 10 Pro - ASUS recommends Windows 10 Pro. Memory. DDR4 2400MHz SDRAM, 1 x SO-DIMM socket , up to 8 GB SDRAM. Display. 14.0" (16:9) LED-backlit HD (1366x768) 60Hz Anti-Glare Panel with 45% NTSC. Graphic Storage.'
  },
  {
    name:'Samsung Galaxy S5',
    imgURL:'https://cdn.pixabay.com/photo/2016/03/01/20/28/phone-1231122__340.jpg',
    price: 35999,
    info:'Samsung Galaxy With Alexa In-built. Freedom To Do More w/ Power Of Your Voice. Shop Now! Accidental Protection. Protegent Antivirus. Additional Warranty. Theft Insurance. Models: HP Pavilion x360 14, HP Gaming Pavilion - 15, OMEN by HP 15, HP Notebook - 15.'
  },
  {
    name:'Iphone 5',
    imgURL:'https://cdn.pixabay.com/photo/2015/03/10/08/51/mobile-666896__340.jpg',
    price:41999,
    info:'Iphone 5 Crafted From Brushed Aluminium. Laptop W/ Intel Core. Shop Today! Sennheiser Headset @ 299. Get 3Yr Premium Support. Cash off on MS Office. Get Warranty Worth@₹3999. Amenities: Dell Power Companion, Dell Bluetooth Mouse.'
  },
  {
    name:'Iphne 4',
    imgURL:'https://cdn.pixabay.com/photo/2013/07/12/18/39/smartphone-153650__340.png',
    price:34000,
    info:'2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory. 2.4GHz 8-core Intel Core i9, Turbo Boost up to 5.0GHz, with 16MB shared L3 cache. 32GB of 2400MHz DDR4 memory. Radeon Pro 560X with 4GB of GDDR5 memory.'
  },
  {
    name:'Intex',
    imgURL:'https://cdn.pixabay.com/photo/2015/01/20/13/13/ipad-605439__340.jpg',
    price:4566,
    info:'This item 2015 Intex Satellite 15.6-inch Laptop- 5th Gen Intel Core i7-5500U Processor 3.0GHz, 4MB Cache, 8GB Memory, 1TB HDD, HDMI, Bluetooth, Webcam, WIFI, AMD R7 M260, Windows 8.1/Windows 10.'
  },
  {
    name:'Karbonn',
    imgURL:'https://cdn.pixabay.com/photo/2015/05/12/09/13/social-media-763731__340.jpg',
    price:4500,
    info:'Comes W/ Infinity Edge IPS Display. Mobiles W/ Intel® Core™ Processor, Buy Now! Cash off on MS Office. Get 3Yr Hardware Warranty. Get 3Yr Premium Support. Amenities: Dell Pro Backpack, Dell Bluetooth Mouse, Dell Professional Headset, Accidental Damage Service.'
  },
  {
    name:'Ikall',
    imgURL:'https://cdn.pixabay.com/photo/2017/04/03/15/52/mobile-phone-2198770__340.png',
    price:5670,
    info:'CPU: 1GHz Intel Core i5-6300U (dual-core, 3MB cache, up to 3GHz with Turbo Boost) Graphics: Intel HD Graphics 520. RAM: 1GB LPDDR3. Screen: 12.3-inch, 2,736 x 1,824 PixelSense display (Contrast ratio: 1,300:1, 100% sRGB color, 10-point multi-touch, 3:2 aspect ratio) Storage: 256GB SSD (PCIe 3.0)'
  }
];
selectedmobile: Mobile = this.mobiles[0];

  constructor() { }

  selectmobile(mobile)
  {
    this.selectedmobile = mobile;
  }
  ngOnInit() {
  }

}

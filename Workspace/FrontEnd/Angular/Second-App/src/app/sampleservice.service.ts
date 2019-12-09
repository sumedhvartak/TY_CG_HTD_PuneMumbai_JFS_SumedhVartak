import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
})
export class SampleService {
    laptop = 'Dell';
    printService(){
        console.log('Function is running');
    }
}
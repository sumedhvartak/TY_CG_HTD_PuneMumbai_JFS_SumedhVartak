import { Directive, ElementRef, HostListener, HostBinding } from '@angular/core';

@Directive({
    selector: '[appColor]'
})
export class ColorDirective{

    constructor(private el : ElementRef){
        this.el.nativeElement.style.backgroundColor = 'red';
        this.el.nativeElement.style.color = 'white';
        this.el.nativeElement.style.padding = '5px';
        //this.el.nativeElement.style.fontSize = '30px';
    }

    @HostBinding('style.fontSize') fontSize

    @HostListener('mouseenter')
    mouseEntered(){
        console.log('mouse enetred');
        this.fontSize = '50px';
        this.el.nativeElement.style.background = 'blue';
    }

    @HostListener('mouseleave')
    mouseLeave(){
        console.log('Mouse Left');
        this.el.nativeElement.style.background = 'black';
    }
    

}
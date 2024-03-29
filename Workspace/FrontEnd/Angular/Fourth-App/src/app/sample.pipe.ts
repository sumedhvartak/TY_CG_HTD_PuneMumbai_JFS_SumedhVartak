import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sample'
})
export class SamplePipe implements PipeTransform {

  transform(value: string, length:number): string {
    return value.substring(0, length) + '...';
  }

}

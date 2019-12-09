import { Component, OnInit } from '@angular/core';
import { Movie } from '../movie';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
movies: Movie[] =[
  {
    name:'Adventure',
    imgURL:'https://cdn.pixabay.com/photo/2016/11/15/07/09/photo-manipulation-1825450__340.jpg',
    rating:'5/10',
    info:'Deprived of his mighty hammer Mjolnir, Thor must escape the other side of the universe to save his home, Asgard, from Hela, the goddess of death.'
  },
  {
    name:'Charlie-Chaplin',
    imgURL:'https://cdn.pixabay.com/photo/2015/08/20/23/44/charlie-chaplin-898316__340.jpg',
    rating:'6/10',
    info:'Sir Charles Spencer Chaplin KBE was an English comic actor, filmmaker, and composer who rose to fame in the era of silent film. He became a worldwide icon through his screen persona, "The Tramp", and is considered one of the most important figures in the history of the film industry.'
  },
  {
    name:'Spider-Man',
    imgURL:'https://cdn.pixabay.com/photo/2019/04/08/16/27/spiderman-4112322__340.jpg',
    rating:'9/10',
    info:'Spider-Man is a fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko. He first appeared in the anthology comic book Amazing Fantasy #15 in the Silver Age of Comic Books.'
  },
  {
    name:'Avengers',
    imgURL:'https://cdn.pixabay.com/photo/2018/05/08/11/36/avenger-3382834__340.jpg',
    rating:'10/10',
    info:'Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with'
  },
  {
    name:'Iron-Man',
    imgURL:'https://cdn.pixabay.com/photo/2019/05/25/12/30/iron-man-4228269__340.jpg',
    rating:'9/10',
    info:'When an industrialist is captured, he constructs a high-tech armoured suit to escape. Once he manages to escape, he decides to use his suit to fight against evil forces and save the world.'
  },
  {
    name:'Supermann',
    imgURL:'https://cdn.pixabay.com/photo/2017/07/14/12/58/superhero-2503808__340.jpg',
    rating:'8/10',
    info:'Superman is a fictional superhero. The character was created by writer Jerry Siegel and artist Joe Shuster, and first appeared in Action Comics #1, a comic book published on April 18, 1938.'
  },
  {
    name:'Captian America',
    imgURL:'https://cdn.pixabay.com/photo/2019/08/25/06/43/captain-america-4428842__340.jpg',
    rating:'10/10',
    info:'After Steve Rogers decides to volunteer as a guinea pig in an experiment, his weak body is fully enhanced. A secret Nazi organisation tries to exploit the technology and he must stand against them.'
  },
  {
    name:'Thor',
    imgURL:'https://cdn.pixabay.com/photo/2019/05/24/10/09/thor-4225949__340.jpg',
    rating:'9/10',
    info:'Thor is exiled by his father, Odin, the King of Asgard, to the Earth to live among mortals. When he lands on Earth, his trusted weapon Mjolnir is discovered and captured by S.H.I.E.L.D.'
  }
 ];
 selectedMovie: Movie= this.movies[0];
  constructor() { }
  selectmovie(movie){
    this.selectedMovie = movie;
  }
  ngOnInit() {
  }

}

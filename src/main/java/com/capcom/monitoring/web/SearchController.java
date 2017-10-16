package com.capcom.monitoring.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capcom.monitoring.model.MovieSearch;
import com.capcom.monitoring.model.MovieSearchResult;
import com.capcom.monitoring.service.SearchService;


@Controller
public class SearchController {
	
	@Autowired
	SearchService searchService;
	
	@RequestMapping("/index")
	//@ResponseBody
	public String index() {
		System.out.println("Indexxxxxxxxxx");
		return "index";
	}
	
	@RequestMapping("/movieSearch")
	public ModelAndView searchMovie(@RequestParam(value = "searchKey") String searchKey) {
		System.out.println("In serachMovie :: "+searchKey);
		ModelAndView mv = new ModelAndView();
		ModelMap model = new ModelMap();
		
		MovieSearch movie = getMovie();
		
		MovieSearchResult searchResult = searchService.getMovieSearchResult(searchKey);
		List<MovieSearch> movieList = searchResult.getResults();
		System.out.println(movieList);
			
		model.addAttribute("movieName", searchKey);
		model.addAttribute("movie", movie);
		model.addAttribute("searchResult", movieList);
		
		mv.addAllObjects(model);
		mv.setViewName("searchResult");		
		return mv;
	}

	private MovieSearch getMovie() {
		MovieSearch movie = new MovieSearch();
		movie.setPoster_path("/tkt9xR1kNX5R9rCebASKck44si2.jpg");
		movie.setAdult(false);
		movie.setOverview("Jack Sparrow, a freewheeling 17th-century pirate who roams the Caribbean Sea, butts heads with a rival pirate bent on pillaging the village of Port Royal. When the governor's daughter is kidnapped, Sparrow decides to help the girl's love save her. But their seafaring mission is hardly simple.");
		movie.setRelease_date("2003-07-09");
		movie.setOriginal_title("Pirates of the Caribbean: The Curse of the Black Pearl");
		List<Integer> genreList = new ArrayList<>();
		genreList.add(12);
		genreList.add(14);
		genreList.add(28);
		movie.setGenre_ids(genreList);
		movie.setId(22);
		movie.setOriginal_language("en");
		movie.setTitle("Pirates of the Caribbean: The Curse of the Black Pearl");
		movie.setBackdrop_path("/8AUQ7YlJJA9C8kWk8P4YNHIcFDE.jpg");
		movie.setPopularity(16.772561);
		movie.setVote_count(4774);
		movie.setVideo(false);
		movie.setVote_average(7.4);		
		return movie;
	}

}

/* {
      "poster_path": "/tkt9xR1kNX5R9rCebASKck44si2.jpg",
      "adult": false,
      "overview": "Jack Sparrow, a freewheeling 17th-century pirate who roams the Caribbean Sea, butts heads with a rival pirate bent on pillaging the village of Port Royal. When the governor's daughter is kidnapped, Sparrow decides to help the girl's love save her. But their seafaring mission is hardly simple.",
      "release_date": "2003-07-09",
      "original_title": "Pirates of the Caribbean: The Curse of the Black Pearl",
      "genre_ids": [
        12,
        14,
        28
      ],
      "id": 22,
      "media_type": "movie",
      "original_language": "en",
      "title": "Pirates of the Caribbean: The Curse of the Black Pearl",
      "backdrop_path": "/8AUQ7YlJJA9C8kWk8P4YNHIcFDE.jpg",
      "popularity": 16.772561,
      "vote_count": 4774,
      "video": false,
      "vote_average": 7.4
    },*/

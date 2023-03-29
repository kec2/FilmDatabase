"use strict";

export type SearchData = {
    searchType  : string;
    expression  : string;
    results     : [SearchResult];
    errorMessage: string;
};


export type SearchResult = {
    id         : string;
    resultType : string;
    image      : string;
    title      : string;
    description: string;
}

export type UsageData = {
    count: number;
    maximum: number;
    account: string;
    expireDate: string;
    errorMessage: string;
}

export type KeywordData = {
    keyword     : string;
    items       : [keywordItem];
    errorMessage: string;
}

export type keywordItem = {
    id: string;
    title: string;
    year: string;
    image: string;
    imDbRating: string;
}

export type YouTubeTrailerData = {
    imDbId: string;
    title: string;
    fullTitle: string;
    type: string;
    year: string;
    videoId: string;
    videoUrl: string;
    errorMessage: string;
}

export type CompanyData = {
    id: string;
    name: string;
    items: [ CompanyItem ];
    errorMessage:string;
}

export type CompanyItem = {
    id: string;
    title: string;
    year: string;
    image: string;
    imDbRating: string;
}

export type TitleData = {
    "id": string;
    "title": string;
    "originalTitle": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "image": string;
    "releaseDate": string;
    "runtimeMins": string;
    "runtimeStr": string;
    "plot": string;
    "plotLocal": string;
    "plotLocalIsRtl": boolean;
    "awards": string;
    "directors": string;
    "directorList": [StarShort];
    "writers": string;
    "writerList": [StarShort];
    "stars": string;
    "starList": [StarShort];
    "actorList": [ActorShort];
    "fullCast": FullCastData;
    "genres": string;
    "genreList": [KeyValueItem];
    "companies": string;
    "companyList": [CompanyShort];
    "countries": string;
    "countryList": [KeyValueItem];
    "languages": string;
    "languageList": [KeyValueItem];
    "contentRating": string;
    "imDbRating": string;
    "imDbRatingVotes": string;
    "metacriticRating": string;
    "ratings": RatingsData;
    "wikipedia": WikipediaData;
    "posters": PosterData;
    "images": ImageDate;
    "trailer": TrailerData;
    "boxOffice": BoxOfficeShort;
    "tagline": string;
    "keywords": string;
    "keywordList": [string];
    "similars": [SimilarShort];
    "tvSeriesInfo": TvSeriesInfo;
    "tvEpisodeInfo": TvEpisodeInfo;
    "errorMessage": string;
  }

export type SimilarShort = {
    "id": string;
    "title": string;
    "image": string;
    "imDbRating": string;
}

export type ImageDate = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "items": [ImageDateItem];
    "errorMessage": string;
}

export type ImageDateItem =  {
    "title": string;
    "image": string;
}

export type CompanyShort = {
    "id": string;
    "name": string;
}

export type FullCastData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "directors": CastShort;
    "writers": CastShort;
    "actors": [ActorShort];
    "others": [CastShort];
    "errorMessage": string;
}

export type KeyValueItem = {
    key: string;
    value: string;
}

export type CastShort = {
   "job": string;
   "items": [CastShortItem];
}

export type CastShortItem = {
   "id": string;
   "name": string;
   "description": string;
}

export type ActorShort = {
    "id": string;
    "image": string;
    "name": string;
    "asCharacter": string;
}

export type TvEpisodeInfo = {
    "seriesId": string;
    "seriesTitle": string;
    "seriesFullTitle": string;
    "seriesYear": string;
    "seriesYearEnd": string;
    "seasonNumber": string;
    "episodeNumber": string;
    "previousEpisodeId": string;
    "nextEpisodeId": string;
}

export type TvSeriesInfo = {
    "yearEnd": string;
    "creators": string;
    "creatorList": [StarShort];
    "seasons": [string];
}

export type StarShort = {
    id:	string;
    name: string;
}

export type Actor = {
    "id": string;
    "image": string;
    "name": string;
    "asCharacter": string;
}

export type Writer = {
    "job": string;
    "items": [{
        "id": string;
        "name": string;
        "description": string;
    }];
}

export type FullCastResult = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "directors": {
        "job": string;
        "items": [
            {
                "id": string;
                "name": string;
                "description": string;
            }
        ]
    };
    "writers": {
        "job": string;
        "items": [
            {
                "id": string;
                "name": string;
                "description": string;
            }
        ]
    };
    "actors": [
        {
            "id": string;
            "image": string;
            "name": string;
            "asCharacter": string;
        }
    ];
    "others": [
        {
            "job": string;
            "items": [
                {
                    "id": string;
                    "name": string;
                    "description": string;
                }
            ]
        }
    ];
    "errorMessage": string;
}

export type TrailerData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "videoId": string;
    "videoTitle": string;
    "videoDescription": string;
    "thumbnailUrl": string;
    "uploadDate": string;
    "link": string;
    "linkEmbed": string;
    "errorMessage": string;
}

export type PosterData = {
  "imDbId": string;
  "title": string;
  "fullTitle": string;
  "type": string;
  "year": string;
  "posters": [PosterDataItem];
  "backdrops": [PosterDataItem];
  "errorMessage": string;
}

export type PosterDataItem = {
    "id": string;
    "link": string;
    "aspectRatio": 0;
    "language": string;
    "width": 0;
    "height": 0;
}

export type Images = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "items": [
        {
            "title": string;
            "image": string;
        }
    ];
    "errorMessage": string;
}

export type RatingsData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "imDb": string;
    "metacritic": string;
    "theMovieDb": string;
    "rottenTomatoes": string;
    "filmAffinity": string;
    "errorMessage": string;
}

export type UserRatingDataDetail = {
    rating:	string;
    percent: string;
    votes: string;
}

export type UserRatingDataDemographicDetail = {
    rating:	string;
    votes:	string;
}

export type UserRatingsData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "totalRating": string;
    "totalRatingVotes": string;
    "ratings": [UserRatingDataDetail];
    "demographicAll": UserRatingDataDemographic;
    "demographicMales": UserRatingDataDemographic;
    "demographicFemales": UserRatingDataDemographic;
    "top1000Voters": UserRatingDataDemographicDetail;
    "usUsers": UserRatingDataDemographicDetail;
    "nonUSUsers": UserRatingDataDemographicDetail;
    "errorMessage": string;
}

export type UserRatingDataDemographic = {
    "allAges": UserRatingDataDemographicDetail;
    "agesUnder18": UserRatingDataDemographicDetail;
    "ages18To29": UserRatingDataDemographicDetail;
    "ages30To44": UserRatingDataDemographicDetail;
    "agesOver45": UserRatingDataDemographicDetail;
}

export type SeasonEpisodesData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "episodes": [EpisodeShortDetail];
    "errorMessage": string;
}

export type EpisodeShortDetail = {
   "id": string;
   "seasonNumber": string;
   "episodeNumber": string;
   "title": string;
   "image": string;
   "year": string;
   "released": string;
   "plot": string;
   "imDbRating": string;
   "imDbRatingCount": string;
}

export class ImdbApiClient {
    private API_KEY: string = 'k_4c68ekfj';
    private BASE_URL: string = 'https://imdb-api.com';
    private LANG: string = 'en';

    /*
        Search is same as SearchTitle, search into all titles. It is recommended to use SearchMovie or SearchSeries to search for a movie or series.

        PARAMETERS	REQUIRED	DESCRIPTION
        lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in search action.
        apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
        expression	Required	Expression for search. For examples "Leon The Professional" or "Inception". You can also search with year (ex: "Inception 2010")
        RESULT
    */
    async search(expression: string) : Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/search/${this.API_KEY}/${expression}`;
        let data = await this.fetchData<SearchData>('GET', URL);
        console.log('search: ' + data);
        return data;
    }


    /*
        Search into all titles. It is recommended to use SearchMovieMovie or SearchMovieSeries to SearchMovie for a movie or series.

        PARAMETERS	REQUIRED	DESCRIPTION
        lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in search action.
        apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
        expression	Required	Expression for search. For examples "Leon The Professional" or "Inception". You can also SearchTitle with year (ex: "Inception 2010")
        RESULT
    */
    async searchTitle(expression: string): Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/SearchTitle/${this.API_KEY}/${expression}`;
        let data = await this.fetchData<SearchData>('GET', URL);
        console.log('searchTitle: ' + data);
        return data;
    }

    /*
        Search into all Movies.

        PARAMETERS	REQUIRED	DESCRIPTION
        lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in search action.
        apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
        expression	Required	Expression for search. For examples "Leon The Professional" or "Inception". You can also SearchMovie with year (ex: "Inception 2010")
        RESULT
    */
    async searchMovie(expression: string): Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/SearchMovie/${this.API_KEY}/${expression}`;
        let data = await this.fetchData<SearchData>('GET', URL);
        console.log('searchMovie: ' + data);
        return data;
    }

    /*
        Search into all Series TVs.

        PARAMETERS	REQUIRED	DESCRIPTION
        lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in search action.
        apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
        expression	Required	Expression for search. For examples "Leon The Professional" or "Inception". You can also SearchSeries with year (ex: "Inception 2010")
        RESULT
    */
    async searchSeries(expression: string): Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/SearchSeries/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('searchSeries: ' + data);
        return data;
    }

    /*
        Search into all people.

        PARAMETERS	REQUIRED	DESCRIPTION
        lang	Optional	Language of results. Default value is "en" (English). Language change is not important in search action.
        apiKey	Required	API Key required for all API calls. Register on site to get free API Key.
        expression	Required	Expression for search. Searching people by name (Actors, Actresses, Directors, Writers and ...)
        RESULT
    */
    async searchName(expression: string): Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/SearchName/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('searchName: ' + data);
        return data;
    }

    async searchEpisode(expression: string): Promise<SearchData> {
        const URL = `${this.BASE_URL}/en/API/SearchEpisode/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('searchEpisode: ' + data);
        return data;
    }

    async searchCompany(expression: string): Promise<SearchData> {
        // GET /{lang?}/API/SearchCompany/{apiKey}/{expression}
        const URL = `${this.BASE_URL}/en/API/SearchCompany/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('searchCompany: ' + data);
        return data;
    }

    async searchKeyword(expression: string): Promise<SearchData> {
        // GET /{lang?}/API/SearchKeyword/{apiKey}/{expression}
        const URL = `${this.BASE_URL}/en/API/SearchKeyword/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('searchKeyword: ' + data);
        return data;
    }

    async searchAll(expression: string): Promise<SearchData> {
        // GET /{lang?}/API/SearchAll/{apiKey}/{expression}
        const URL = `${this.BASE_URL}/en/API/SearchAll/${this.API_KEY}/${expression}`;
        let data = this.fetchData<SearchData>('GET', URL);
        console.log('SearchAll: ' + data);
        return data;
    }

     advancedSearch() {
    // GET /{lang?}/API/AdvancedSearch/{apiKey}/?parameters=values}
    }

    /*
    Get Movies or Series TV information.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). PlotLocal and WikipediaPlot properties has been change by your selected language.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    options 	Optional	Options to get more information about: FullActor, FullCast, Posters, Images, Trailer, Ratings, Wikipedia.
    */
    async getTitle(lang: string, id: string, options: string): Promise<TitleData> {
        // GET /{lang?}/API/Title/{apiKey}/{id}/{options?}
        const URL = `${this.BASE_URL}/${lang}/API/Title/${this.API_KEY}/${id}/${options}`;
        let data = this.fetchData<TitleData>('GET', URL);
        console.log('TitleData: ' + data);
        return data;
    }

    /*
    Generate report from Movie or Series TV as PNG image file.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). PlotLocal and WikipediaPlot properties has been change by your selected language.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    options	    Optional	Options to get more information about: FullActor, FullCast, Ratings, Wikipedia.

    TODO this returns a PNG image. Don't know what to do here!!!
    */
    async getReport(lang: string, id: string, options: string): Promise<object> {
        // GET /{lang?}/API/Report/{apiKey}/{id}/{options?}
        const URL = `${this.BASE_URL}/${lang}/API/Report/${this.API_KEY}/${id}/${options}`;
        let data = this.fetchData<object>('GET', URL);
        console.log('Report: ' + data);
        return data;
    }

    /*
    Get full cast/crew and actors/actresses of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getFullCast(id: string): Promise<FullCastResult>{
        // GET /{lang?}/API/FullCast/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/FullCast/${this.API_KEY}/${id}`;
        let data = this.fetchData<FullCastResult>('GET', URL);
        console.log('Report: ' + data);
        return data;
    }

    /*
    Get Posters of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id      	Required	A valid IMDb Id. Id started withs tt.
    */
    async getPosters(id: string): Promise<PosterData> {
        // GET /{lang?}/API/Posters/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Posters/${this.API_KEY}/${id}`;
        let data = this.fetchData<PosterData>('GET', URL);
        console.log('Report: ' + data);
        return data;
    }

    /*
    Get images of Movie or Series TV or People (Name) (tt1234567) and Name (nm1234567).

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt or nm.
    options	    Optional	Options can Short (default) or Full. Short parameter contains 48 images. Full parameter (tt only) contains all available images.
    */
    async getImages(id: string, options: string): Promise<Images>{
        // GET /{lang?}/API/Images/{apiKey}/{id}/{options?}
        const URL = `${this.BASE_URL}/en/API/Images/${this.API_KEY}/${id}/${options}`;
        let data = this.fetchData<Images>('GET', URL);
        console.log('Images: ' + data);
        return data;
    }

    /*
    Get trailers of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
     async getTrailer(id: string): Promise<TrailerData>{
        // GET /{lang?}/API/Trailer/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Trailer/${this.API_KEY}/${id}`;
        let data = this.fetchData<TrailerData>('GET', URL);
        console.log('Trailer: ' + data);
        return data;
    }

    /*
    Get ratings of Movie or Series TV in: IMDb, Metacritic, RottenTomatoes, TheMovieDb and TV.com.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getRatings(id: string): Promise<RatingsData> {
        // GET /{lang?}/API/Ratings/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Ratings/${this.API_KEY}/${id}`;
        let data = this.fetchData<RatingsData>('GET', URL);
        console.log('Ratings: ' + data);
        return data;
    }

    /*
    Get user ratings of Movie or Series TV with count of votes and details.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getUserRatings(id: string): Promise<UserRatingsData> {
        // GET /{lang?}/API/UserRatings/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/UserRatings/${this.API_KEY}/${id}`;
        let data = this.fetchData<UserRatingsData>('GET', URL);
        console.log('UserRatings: ' + data);
        return data;
    }

    /*
    Get episodes of season in Series TV.

    PARAMETERS	    REQUIRED	DESCRIPTION
    lang	        Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	        Required	API Key required for all API calls. Register on site to get free API Key.
    id	            Required	A valid IMDb Id. Id started withs tt.
    seasonNumber	Required	Season number to get episodes.
    */
    async getSeasonEpisodes(id: string, seasonNumber: string): Promise<SeasonEpisodesData> {
        // GET /{lang?}/API/SeasonEpisodes/{apiKey}/{id}/{seasonNumber}
        const URL = `${this.BASE_URL}/en/API/SeasonEpisodes/${this.API_KEY}/${id}/${seasonNumber}`;
        let data = this.fetchData<SeasonEpisodesData>('GET', URL);
        console.log('SeasonEpisodes: ' + data);
        return data;
    }

    /*
    Get Movie or Series TV in all external sites with Identifier and URL.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getExternalSites(id: string): Promise<ExternalSitesData> {
        // GET /{lang?}/API/ExternalSites/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/ExternalSites/${this.API_KEY}/${id}`;
        let data = this.fetchData<ExternalSitesData>('GET', URL);
        console.log('ExternalSites: ' + data);
        return data;
    }

    /*
    Get Wikipedia plot of Movie or Series TV (tt1234567) as PlainText and Html.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	Optional	Language of results. Default value is "en" (English). Language is important for return value of wikipedia plot.
    apiKey	Required	API Key required for all API calls. Register on site to get free API Key.
    id	    Required	A valid IMDb Id. Id started withs tt.
    */
    async getWikipedia(id: string, lang: string): Promise<WikipediaData> {
        // GET /{lang?}/API/Wikipedia/{apiKey}/{id}
        const URL = `${this.BASE_URL}/${lang}/API/Wikipedia/${this.API_KEY}/${id}`;
        let data = this.fetchData<WikipediaData>('GET', URL);
        console.log('Wikipedia: ' + data);
        return data;
    }

    /*
    Get data from IMDb List.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb List Id. Id started withs ls.
    */
    async getIMDbList(id: string): Promise<IMDbListData> {
        // GET /{lang?}/API/IMDbList/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/IMDbList/${this.API_KEY}/${id}`;
        let data = this.fetchData<IMDbListData>('GET', URL);
        console.log('IMDbList: ' + data);
        return data;
    }

    /*
    Get user reviews of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getReviews(id: string): Promise<ReviewData> {
        // GET /{lang?}/API/Reviews/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Reviews/${this.API_KEY}/${id}`;
        let data = this.fetchData<ReviewData>('GET', URL);
        console.log('Reviews: ' + data);
        return data;
    }

    /*
    Get Metacritic reviews of Movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getMetacriticReviews(id: string): Promise<MetacriticReviewData> {
        // GET /{lang?}/API/MetacriticReviews/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/MetacriticReviews/${this.API_KEY}/${id}`;
        let data = this.fetchData<MetacriticReviewData>('GET', URL);
        console.log('MetacriticReviews: ' + data);
        return data;
    }

    /*
    Get FAQ of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getFaq(id: string): Promise<FaqData> {
        // GET /{lang?}/API/FAQ/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/FAQ/${this.API_KEY}/${id}`;
        let data = this.fetchData<FaqData>('GET', URL);
        console.log('FAQ: ' + data);
        return data;
    }

    /*
    Get Awards of Movie or Series TV.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Id. Id started withs tt.
    */
    async getAwards(id: string): Promise<AwardsData> {
        // GET /{lang?}/API/Awards/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Awards/${this.API_KEY}/${id}`;
        let data = this.fetchData<AwardsData>('GET', URL);
        console.log('Awards: ' + data);
        return data;
    }

    //function get(){Others}

    /*
    Get Top 250 Movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getTop250Movies():Promise<Top250Data> {
        // GET /{lang?}/API/Top250Movies/{apiKey}
        const URL = `${this.BASE_URL}/en/API/Top250Movies/${this.API_KEY}`;
        let data = this.fetchData<Top250Data>('GET', URL);
        console.log('Top250Movies: ' + data);
        return data;
    }



    /*
    Get Top 250 Series TVs.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getTop250TVs(): Promise<Top250Data> {
        // GET /{lang?}/API/Top250TVs/{apiKey}
        const URL = `${this.BASE_URL}/en/API/Top250TVs/${this.API_KEY}`;
        let data = this.fetchData<Top250Data>('GET', URL);
        console.log('Top250TVs: ' + data);
        return data;
    }

    /*
    Get Top 100 Most Polular Movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getMostPopularMovies(): Promise<Top250Data> {
        // GET /{lang?}/API/MostPopularMovies/{apiKey}
        const URL = `${this.BASE_URL}/en/API/MostPopularMovies/${this.API_KEY}`;
        let data = this.fetchData<Top250Data>('GET', URL);
        console.log('MostPopularMovies: ' + data);
        return data;
    }

    /*
    Get Top 100 Most Popular Series TVs.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getMostPopularTVs(): Promise<Top250Data> {
        // GET /{lang?}/API/MostPopularTVs/{apiKey}
        const URL = `${this.BASE_URL}/en/API/MostPopularTVs/${this.API_KEY}`;
        let data = this.fetchData<Top250Data>('GET', URL);
        console.log('MostPopularTVs: ' + data);
        return data;
    }

    /*
    Get In Theaters Movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getInTheaters(): Promise<InTheatersData> {
        // GET /{lang?}/API/InTheaters/{apiKey
        const URL = `${this.BASE_URL}/en/API/InTheaters/${this.API_KEY}`;
        let data = this.fetchData<InTheatersData>('GET', URL);
        console.log('InTheaters: ' + data);
        return data;
    }

    /*
    Get Coming Soon Movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getComingSoon(): Promise<InTheatersData> {
        // GET /{lang?}/API/ComingSoon/{apiKey}
        const URL = `${this.BASE_URL}/en/API/ComingSoon/${this.API_KEY}`;
        let data = this.fetchData<InTheatersData>('GET', URL);
        console.log('ComingSoon: ' + data);
        return data;
    }

    /*
    Get Weekend Box Office.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getBoxOffice(): Promise<BoxOfficeData> {
        // GET /{lang?}/API/BoxOffice/{apiKey}
        const URL = `${this.BASE_URL}/en/API/BoxOffice/${this.API_KEY}`;
        let data = this.fetchData<BoxOfficeData>('GET', URL);
        console.log('BoxOffice: ' + data);
        return data;
    }

    /*
    Get Box Office in all times.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getBoxOfficeAllTime(): Promise<BoxOfficeAllTimeData> {
        // GET /{lang?}/API/BoxOfficeAllTime/{apiKey}
        const URL = `${this.BASE_URL}/en/API/BoxOfficeAllTime/${this.API_KEY}`;
        let data = this.fetchData<BoxOfficeAllTimeData>('GET', URL);
        console.log('BoxOfficeAllTime: ' + data);
        return data;
    }

    /*
    Get information of people (actor, actress, director, writers, ...).

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey  	Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Name Id. Id startd withs nm.
    */
    async getName(id: string): Promise<NameData> {
        // GET /{lang?}/API/Name/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/Name/${this.API_KEY}/${id}`;
        let data = this.fetchData<NameData>('GET', URL);
        console.log('Name: ' + data);
        return data;
    }

    /*
    Get Awards of people.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id      	Required	A valid IMDb Name Id. Id started withs nm.
    */
    async getNameAwards(id: string): Promise<NameAwardsData>{
        // GET /{lang?}/API/NameAwards/{apiKey}/{id}
        const URL = `${this.BASE_URL}/en/API/NameAwards/${this.API_KEY}/${id}`;
        let data = this.fetchData<NameAwardsData>('GET', URL);
        console.log('NameAwards: ' + data);
        return data;
    }

    /*
    Get information of company with movies.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Company Id. Id started withs co.
    RESULT
    */
    async getCompany(id: string): Promise<CompanyData> {
        const URL = `${this.BASE_URL}/en/API/Company/${this.API_KEY}/${id}`;
        let data = this.fetchData<CompanyData>('GET', URL);
        console.log('Company: ' + data);
        return data;
    }

    /*
    Get Movie or Series TVs in this keyword.

    PARAMETERS	REQUIRED	DESCRIPTION
    lang	    Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	    Required	API Key required for all API calls. Register on site to get free API Key.
    id	        Required	A valid IMDb Keyword (already founded in SearchKeyword action)
    */
    async getKeyword(id: string): Promise<KeywordData> {
        const URL = `${this.BASE_URL}/en/API/Keyword/${this.API_KEY}/${id}`;
        let data = this.fetchData<KeywordData>('GET', URL);
        console.log('Keyword: ' + data);
        return data;
    }

    /*
    Get YouTube Trailer URL by IMDb Id.

    lang	Optional	Language of results. Default value is "en" (English). Language change is not important in this action.
    apiKey	Required	API Key required for all API calls. Register on site to get free API Key.
    id      Required	A valid IMDb Id. Id started withs tt.
    */
    async getYouTubeTrailer(id: string): Promise<YouTubeTrailerData> {
        const URL = `${this.BASE_URL}/en/API/YouTubeTrailer/${this.API_KEY}/${id}`;
        let data = this.fetchData<YouTubeTrailerData>('GET', URL);
        console.log('YouTubeTrailer: ' + data);
        return data;
    }



    // Tools

    /*
    View the number of daily uses of the services..
    apiKey	Required	API Key required for all API calls. Register on site to get free API Key.
    */
    async getUsage(): Promise<UsageData> {
        const URL = `${this.BASE_URL}/API/Usage/${this.API_KEY}`;
        let data = this.fetchData<UsageData>('GET', URL);
        console.log('Usage: ' + data);
        return data;
    }

    /*
    apiKey	Required	API Key required for all API calls. Register on site to get free API Key.
    size	Required	Size of Image. Examples: 8x11, 16x22, 32x44, 64x88, ... (Width x Height)
    url	Required	URL of Image.
    RESULT	URL Of JPG Image
    */
    async resizeImage(size: string, url: string): Promise<string> {
        const URL = `${this.BASE_URL}/API/ResizeImage?apikey=${this.API_KEY}&size=${size}&url=${url}`;
        let data = this.fetchData<string>('GET', URL);
        console.log('ResizeImage: ' + data);
        return data;
    }


    /*
    Get Image by size.
    @param {string} size - Size of Poster.
    Supported Sizes
    Wide - Ratio 6:9/9:6 : original, w45, w92, w154, w185, w200, w300, w342, w400, w500, w780 and w1280
    Square - Ratio 1:1 : s32, s45, s50, s64, s66, s90, s100, s115, s128, s132, s150, s180, s230, s235, s264, s300, s375, s470
    @returns {string} 	URL Of JPG Image
    */
    async resizePoster(size: string, url: string): Promise<string> {
        const URL = `${this.BASE_URL}/API/resizePoster?apikey=${this.API_KEY}&size=${size}&url=${url}`;
        let data = this.fetchData<string>('GET', URL);
        console.log('resizePoster: ' + data);
        return data;
    }

    private getImdbUrl(): string {
        return `${this.BASE_URL}/{LANG}/{this.API_KEY}`;
    }

    /*
    method:  *GET, POST, PUT, DELETE, etc.
    */
    private async fetchData<T>(method: string, url: string): Promise<T>  {
        console.log('method: ' + method);
        console.log('url:    ' + url);

        let response = await fetch(url);
        if (!response.ok) {
            throw Error("...");
        }

        const data: T = await response.json();

        console.log(data);
        return data;
    }
}

export type ExternalSiteItem = {
    id:	string;
    url: string;
}

export type ExternalSitesData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "officialWebsite": string;
    "imDb": ExternalSiteItem;
    "theMovieDb": ExternalSiteItem;
    "rottenTomatoes": ExternalSiteItem;
    "metacritic": ExternalSiteItem;
    "netflix": ExternalSiteItem;
    "googlePlay": ExternalSiteItem;
    "filmAffinity": ExternalSiteItem;
    "freebase": ExternalSiteItem;
    "gnd": ExternalSiteItem,
    "viaf": ExternalSiteItem;
    "alloCine": ExternalSiteItem;
    "allMovie": ExternalSiteItem;
    "port": ExternalSiteItem;
    "dnf": ExternalSiteItem;
    "movieMeter": ExternalSiteItem;
    "boxOfficeMojo": ExternalSiteItem;
    "csfd": ExternalSiteItem;
    "kinenote": ExternalSiteItem;
    "allcinema": ExternalSiteItem;
    "kinopoisk": ExternalSiteItem;
    "elonet": ExternalSiteItem;
    "ldiF": ExternalSiteItem;
    "cineplex": ExternalSiteItem;
    "eDb": ExternalSiteItem;
    "elCinema": ExternalSiteItem;
    "scope_dk": ExternalSiteItem;
    "swedishFilmDatabaseFilm": ExternalSiteItem;
    "elFilm": ExternalSiteItem;
    "ofDb": ExternalSiteItem;
    "openMediaDatabase": ExternalSiteItem;
    "quoraTopic": ExternalSiteItem;
    "cinema_de": ExternalSiteItem;
    "deutscheSynchronkartei": ExternalSiteItem;
    "movieWalker": ExternalSiteItem;
    "tvGuide": ExternalSiteItem;
    "filmweb_pl": ExternalSiteItem;
    "isan": ExternalSiteItem;
    "eidr": ExternalSiteItem;
    "afiCatalogOfFeature": ExternalSiteItem;
    "theNumbers": ExternalSiteItem;
    "tcmMovieDatabase": ExternalSiteItem;
    "cine_gr": ExternalSiteItem;
    "bfiNationalArchive": ExternalSiteItem;
    "exploitationVisa": ExternalSiteItem;
    "sratim": ExternalSiteItem;
    "cineRessources": ExternalSiteItem;
    "cinemathequeQuebecoise": ExternalSiteItem;
    "encyclopaediaBritannicaOnline": ExternalSiteItem;
    "bechdelTestMovieList": ExternalSiteItem;
    "movieplayer_it": ExternalSiteItem;
    "mYmovies": ExternalSiteItem;
    "cinematografo": ExternalSiteItem;
    "lumiere": ExternalSiteItem;
    "bfi": ExternalSiteItem;
    "prisma": ExternalSiteItem;
    "cineMagia": ExternalSiteItem;
    "daum": ExternalSiteItem;
    "douban": ExternalSiteItem;
    "museumOfModernArt": ExternalSiteItem;
    "ilMondoDeiDoppiatori": ExternalSiteItem;
    "fandango": ExternalSiteItem;
    "moviepilot_de": ExternalSiteItem;
    "sudocAuthorities": ExternalSiteItem;
    "bibliothequeNationaleDeFrance": ExternalSiteItem;
    "siamzone": ExternalSiteItem;
    "academyAwardsDatabase": ExternalSiteItem;
    "knowYourMeme": ExternalSiteItem;
    "theEncyclopediaOfScienceFiction": ExternalSiteItem;
    "letterboxd": ExternalSiteItem;
    "comicVine": ExternalSiteItem;
    "theTVDB": ExternalSiteItem;
    "tvSpielfilmSeries": ExternalSiteItem;
    "wikipediaUrls": [LanguageUrl];
    "errorMessage": string;
}

export type LanguageUrl = {
    "language": string;
    "title": string;
    "url": string;
}

export type WikipediaData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "language": string;
    "titleInLanguage": string;
    "url": string;
    "plotShort": WikipediaPlotData;
    "plotFull": WikipediaPlotData;
    "errorMessage": string;
}

export type WikipediaPlotData = {
    "plainText": string;
    "html": string;
}

export type IMDbListData = {
    "title": string;
    "by": string;
    "created": string;
    "updated": string;
    "description": string;
    "items": [IMDbListDataDetail],
    "errorMessage": string;
}

export type IMDbListDataDetail = {
    "id": string;
    "index": string;
    "title": string;
    "fullTitle": string;
    "year": string;
    "image": string;
    "imDbRating": string;
    "imDbRatingCount": string;
    "description": string;
}

export type ReviewData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "items": [ReviewDetail],
    "errorMessage": string;
}

export type ReviewDetail = {
    "username": string;
    "userUrl": string;
    "reviewLink": string;
    "warningSpoilers": boolean;
    "date": string;
    "rate": string;
    "helpful": string;
    "title": string;
    "content": string;
}

export type MetacriticReviewDetail = {
    "publisher": string;
    "author": string;
    "link": string;
    "rate": string;
    "content": string;
}

export type MetacriticReviewData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "items": [MetacriticReviewDetail],
    "errorMessage": string;
}

export type FaqData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "items": [
        {
              "question": string;
              "answer": string;
        }
    ],
    "spoilerItems": [
        {
            "question": string;
            "answer": string;
        }
    ],
    "errorMessage": string;
}

export type AwardsData = {
    "imDbId": string;
    "title": string;
    "fullTitle": string;
    "type": string;
    "year": string;
    "description": string;
    "items": [
        {
            "eventTitle": string;
            "eventYear": string;
            "outcomeItems": [
                {
                    "outcomeTitle": string;
                    "outcomeCategory": string;
                    "outcomeDetails": [
                        {
                            "plainText": string;
                            "html": string;
                        }
                    ]
                }
            ]
        }
    ],
    "awardsHtml": string;
    "errorMessage": string;
}

export type NameAwardsData = {
    "imDbId": string;
    "name": string;
    "description": string;
    "items": [
        {
            "eventTitle": string;
            "outcomeItems": [
                {
                    "outcomeYear": string;
                    "outcomeTitle": string;
                    "outcomeCategory": string;
                    "outcomeDetails": [
                        {
                            "plainText": string;
                            "html": string;
                        }
                    ]
                }
            ]
        }
    ],
    "nameAwardsHtml": string;
    "errorMessage": string;
}


export type Top250Data = {
    "items": [Top250DataDetail];
    "errorMessage": string;
}

export type Top250DataDetail = {
     "id": string;
     "rank": string;
     "title": string;
     "fullTitle": string;
     "year": string;
     "image": string;
     "crew": string;
     "imDbRating": string;
     "imDbRatingCount": string;
}

export type InTheatersData = {
  "items": [
    {
      "id": string;
      "title": string;
      "fullTitle": string;
      "year": string;
      "releaseState": string;
      "image": string;
      "runtimeMins": string;
      "runtimeStr": string;
      "plot": string;
      "contentRating": string;
      "imDbRating": string;
      "imDbRatingCount": string;
      "metacriticRating": string;
      "genres": string;
      "genreList": [
        {
          "key": string;
          "value": string;
        }
      ],
      "directors": string;
      "directorList": [
        {
          "id": string;
          "name": string;
        }
      ],
      "stars": string;
      "starList": [
        {
          "id": string;
          "name": string;
        }
      ]
    }
  ],
  "errorMessage": string;
}

export type BoxOfficeShort = {
    "budget": string;
    "openingWeekendUSA": string;
    "grossUSA": string;
    "cumulativeWorldwideGross": string;
}

export type BoxOfficeData = {
  "items": [
    {
      "id": string;
      "rank": string;
      "title": string;
      "image": string;
      "weekend": string;
      "gross": string;
      "weeks": string;
    }
  ],
  "errorMessage": string;
}

export type BoxOfficeAllTimeData = {
  "items": [
    {
      "id": string;
      "rank": string;
      "title": string;
      "worldwideLifetimeGross": string;
      "domesticLifetimeGross": string;
      "domestic": string;
      "foreignLifetimeGross": string;
      "foreign": string;
      "year": string;
    }
  ],
  "errorMessage": string;
}

export type NameData = {
  "id": string;
  "name": string;
  "role": string;
  "image": string;
  "summary": string;
  "birthDate": string;
  "deathDate": string;
  "awards": string;
  "height": string;
  "knownFor": [
    {
      "id": string;
      "title": string;
      "fullTitle": string;
      "year": string;
      "role": string;
      "image": string;
    }
  ],
  "castMovies": [
    {
      "id": string;
      "role": string;
      "title": string;
      "year": string;
      "description": string;
    }
  ],
  "errorMessage": string;
}
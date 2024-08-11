package com.example.newsdevappimport android.os.Bundleimport androidx.activity.ComponentActivityimport androidx.activity.compose.setContentimport androidx.navigation.compose.rememberNavControllerimport com.example.feature.news.di.DaggerNewsComponentimport com.example.feature.search.di.DaggerSearchNewsComponentimport com.example.network.di.DaggerNetworkComponentimport com.example.newsdevapp.newsapp.NewsApplicationimport com.example.newsdevapp.ui.theme.MovieDevAppThemeclass MainActivity : ComponentActivity() {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        val appComponent = (applicationContext as NewsApplication).appComponent        val networkComponent = DaggerNetworkComponent.create()        val newsComponent = DaggerNewsComponent            .factory()            .createNetworkApi(networkComponent)        val newsSearchComponent = DaggerSearchNewsComponent            .factory()            .createNetworkApi(networkComponent)        appComponent.inject(this)        setContent {            MovieDevAppTheme {                val navController = rememberNavController()                NavHostNewDevApp(                    navController = navController,                    newsStore = newsComponent.getNewsStore(),                    searchNewsStore = newsSearchComponent.getSearchNewsStore()                )            }        }    }}
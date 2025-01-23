package com.android.jikan.animeApp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class AnimeListResponse(
    val pagination: Pagination,
    val data: List<AnimeListData>,
)

data class Pagination(
    @SerializedName("last_visible_page")
    val lastVisiblePage: Long,
    @SerializedName("has_next_page")
    val hasNextPage: Boolean,
    @SerializedName("current_page")
    val currentPage: Long,
    val items: Items,
)

data class Items(
    val count: Long,
    val total: Long,
    @SerializedName("per_page")
    val perPage: Long,
)

@Parcelize
data class AnimeListData(
    @SerializedName("mal_id")
    val malId: Long,
    val url: String,
    val images: Images,
    val trailer: Trailer,
    val approved: Boolean,
    val titles: List<Title>,
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String?,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    val type: String,
    val source: String,
    val episodes: Long,
    val status: String,
    val airing: Boolean,
    val aired: Aired,
    val duration: String,
    val rating: String,
    val score: Double,
    @SerializedName("scored_by")
    val scoredBy: Long,
    val rank: Long,
    val popularity: Long,
    val members: Long,
    val favorites: Long,
    val synopsis: String,
    val background: String,
    val season: String?,
    val year: Long?,
    val broadcast: Broadcast,
    val producers: List<Producer>,
    val licensors: List<Licensor>,
    val studios: List<Studio>,
    val genres: List<Genre>,
    @SerializedName("explicit_genres")
    val explicitGenres: List<Demographic>,
    val themes: List<Theme>,
    val demographics: List<Demographic>,
):Parcelable

@Parcelize
data class Images(
    val jpg: Jpg,
    val webp: Webp,
):Parcelable

@Parcelize
data class Jpg(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
):Parcelable

@Parcelize
data class Webp(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String,
):Parcelable

@Parcelize
data class Trailer(
    @SerializedName("youtube_id")
    val youtubeId: String?,
    val url: String?,
    @SerializedName("embed_url")
    val embedUrl: String?,
    val images: Images2,
):Parcelable

@Parcelize
data class Images2(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("small_image_url")
    val smallImageUrl: String?,
    @SerializedName("medium_image_url")
    val mediumImageUrl: String?,
    @SerializedName("large_image_url")
    val largeImageUrl: String?,
    @SerializedName("maximum_image_url")
    val maximumImageUrl: String?,
):Parcelable

@Parcelize
data class Title(
    val type: String,
    val title: String,
):Parcelable

@Parcelize
data  class Aired(
    val from: String,
    val to: String?,
    val prop: Prop,
    val string: String,
):Parcelable

@Parcelize
data  class Prop(
    val from: From,
    val to: To,
):Parcelable

@Parcelize
data  class From(
    val day: Long,
    val month: Long,
    val year: Long,
):Parcelable

@Parcelize
data  class To(
    val day: Long?,
    val month: Long?,
    val year: Long?,
):Parcelable

@Parcelize
data  class Broadcast(
    val day: String?,
    val time: String?,
    val timezone: String?,
    val string: String?,
):Parcelable

@Parcelize
data  class Producer(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

@Parcelize
data  class Licensor(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

@Parcelize
data  class Studio(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

@Parcelize
data  class Genre(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

@Parcelize
data  class Theme(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

@Parcelize
data  class Demographic(
    @SerializedName("mal_id")
    val malId: Long,
    val type: String,
    val name: String,
    val url: String,
):Parcelable

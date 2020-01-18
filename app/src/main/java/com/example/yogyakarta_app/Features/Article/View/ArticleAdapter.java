package com.example.yogyakarta_app.Features.Article.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yogyakarta_app.Data.Db.Entity.Article;
import com.example.yogyakarta_app.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleHolder> {

    private List<Article> articles = new ArrayList<>();
    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.article_item,viewGroup,false);
        return new ArticleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder articleHolder, int i) {
        Article currentArticle = articles.get(i);
        articleHolder.textViewTitle.setText(currentArticle.getTitle());
        articleHolder.textViewAuthor.setText(currentArticle.getAuthor());
        articleHolder.textViewContent.setText(currentArticle.getContent());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }
    class ArticleHolder extends RecyclerView.ViewHolder{

        private TextView textViewTitle;
        private TextView textViewAuthor;
        private TextView textViewContent;

        public ArticleHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_article_title);
            textViewAuthor = itemView.findViewById(R.id.text_view_article_author);
            textViewContent = itemView.findViewById(R.id.text_view_article_content);
        }
    }
}

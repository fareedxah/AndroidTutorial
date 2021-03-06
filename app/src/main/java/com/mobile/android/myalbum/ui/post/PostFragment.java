package com.mobile.android.myalbum.ui.post;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mobile.android.myalbum.BaseDaggerFragment;
import com.mobile.android.myalbum.R;
import com.mobile.android.myalbum.model.post.Post;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PostFragment extends BaseDaggerFragment implements PostContract.View {

    @BindView(R.id.fragmentRecyclerView)
    RecyclerView postRecyclerView;

    @Inject
    PostContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        requireActivity().setTitle("Posts");
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        presenter.getPosts();
    }

    @Override
    public void displayPosts(List<Post> postList) {
        postRecyclerView.setAdapter(new PostAdapter(postList));
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}

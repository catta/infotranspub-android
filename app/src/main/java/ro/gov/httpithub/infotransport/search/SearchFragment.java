package ro.gov.httpithub.infotransport.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ro.gov.httpithub.infotransport.R;
import ro.gov.httpithub.infotransport.route.RouteActivity;

import static com.google.common.base.Preconditions.checkNotNull;

public class SearchFragment extends Fragment implements SearchContract.View {
    private SearchContract.Presenter mPresenter;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        // Set up floating action button
        FloatingActionButton fab =
                (FloatingActionButton) getActivity().findViewById(R.id.fab_get_route);

        fab.setImageResource(R.drawable.ic_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getRoute();
            }
        });

        return root;
    }

    @Override
    public void setPresenter(@NonNull SearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showRoute() {
        Intent intent = new Intent(getContext(), RouteActivity.class);
        startActivityForResult(intent, SearchActivity.REQUEST_ROUTE);
    }
}

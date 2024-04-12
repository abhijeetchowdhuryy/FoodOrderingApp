package com.example.sizzlingbitesapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.inputmethod.InputMethodManager;

public class SearchFragment extends Fragment {

    EditText searchbar;
    ImageView search_icon;
    ListView listView;

    String[] name = {"Mexican Burger","Cheese Burger","Turkey Burger","Veggie Burger","Bean Burger","Wild Salmon Buger","Hamburger","Portobello Brger","Elk Burger","Beyond meat Brger","Buffalo Burger","Bacon Cheeseburge","Shawarma Burger","Muffaletta Burger","Kimchi Burger","Nutburger", "Slaw Burger",
            "Margherita Pizza","BBQ Chicken Pizza","Pepperoni Pizza","Hawaiian Pizza","Meat Lovers Pizza","Veggie Pizza","Cheese Pizza","Mushroom Pizza","Sausage Pizza","Buffalo Pizza","Neapolitan Pizza","Chicago style pizza","Bagel pizza","Roman pizza","New York Style Pizza","Sicilian Style Pizza","Detroit Style Pizza",
            "Cappuccino","Mocha","Americano","Cortado","Flat White","Affogato","Irish Coffee","Turkish Coffee","Café au lait","Caffe Breve", "Black Coffee","Con Panna","Frappuccino","Iced Coffee","Lungo","Red Eye","Vienna",
            "Virgin pina colada","Spicy Watermelon","Cranberry sangria","Shirley Temple","Virgin Mary","Berry Cooler","Virgin margarita","Strawberry daiquiri","Hurricane Mocktail","Lavender lemonade","Negroni mocktail","Virgin Gimlet","Arnold Palmer","Cherry Punch","Citrus Fizz","Dragonfruit mocktail","Frozen lemonade",
            "Standard French Fries","Steak Fries","Crinkle Cut Fries","Shoestring Fry","Matchstick Fry","Waffle Fries","Wedge-cut fries","Cheese fries","Cottage Fry","Potato Tornado","Garlic fries","Curly Fries","Truffle Fries","Animal-style Fries","Poutine Hails","Loaded French Fries","Honey Butter Fries",
            "Pinwheel Sandwich","Grilled Sandwich","Club Sandwich","Falafel","Vegetable Sandwich","Chicken Sandwich","Egg Sandwich","Ham Sandwich","Bánh mì","Sabich Sandwich","Meatball Sandwich","Nutella sandwich","Reuben sandwich","French Sandwich","Roast-Beef Sandwich","Salmon Sandwich","Olive Sandwich"};

    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false);
        searchbar = root.findViewById(R.id.searchbar);
        search_icon = root.findViewById(R.id.search_icon);
        listView = root.findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, name);
        listView.setAdapter(adapter);

        // Set click listener for search icon
        search_icon.setOnClickListener(v -> performSearch());

        // Automatically focus on search bar and show keyboard
        searchbar.requestFocus();
        InputMethodManager imm = (InputMethodManager) requireActivity().getSystemService(getContext().INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        return root;
    }

    private void performSearch() {
        String query = searchbar.getText().toString().trim();

        if (!query.isEmpty()) {
            // Filter the adapter based on the query
            adapter.getFilter().filter(query);
        } else {
            // If search query is empty, show a message
            Toast.makeText(getContext(), "Please enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.sizzlingbitesapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRvViewHolder>{

    private ArrayList<StaticRvModel> items;
    int row_index = -1;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;

    private int selectedPosition = RecyclerView.NO_POSITION;

    public StaticRvAdapter(ArrayList<StaticRvModel> items, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.items = items;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StaticRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item, parent, false);
        return new StaticRvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRvViewHolder holder, int position) {
        StaticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.title.setText(currentItem.getText());

        if (check) {

            ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
            items.add(new DynamicRVModel("Mexican Burger","Blend of seasoned ground beef", R.drawable.mexicanburger, 0));
            items.add(new DynamicRVModel("Cheese Burger"," Juicy patty with melted cheese", R.drawable.cheeseburger, 0));
            items.add(new DynamicRVModel("Turkey Burger"," Crafted from ground turkey meat", R.drawable.turkeyburger, 0));
            items.add(new DynamicRVModel("Veggie Burger"," Blend of veggies, grains and spices", R.drawable.veggieburger, 0));
            items.add(new DynamicRVModel("Bean Burger","Hearty vegetarian mashed beans", R.drawable.beanburger, 0));
            items.add(new DynamicRVModel("Wild Salmon Burger","Made from fresh wild-caught salmon", R.drawable.wildsalmonburger, 0));
            items.add(new DynamicRVModel("Hamburger","American staple, grilled beef patty", R.drawable.hamburger, 0));
            items.add(new DynamicRVModel("Portobello Burger","Large Portobello mushroom cap grill", R.drawable.portbelloburger, 0));
            items.add(new DynamicRVModel("Elk Burger","Elk meat with herbs and spices", R.drawable.elkburger, 0));
            items.add(new DynamicRVModel("Beyond meat Burger","Blend of pea protein & coconut oil", R.drawable.beyondmeatburger, 0));
            items.add(new DynamicRVModel("Buffalo Burger","Buffalo meat, from American bison", R.drawable.buffaloburger, 0));
            items.add(new DynamicRVModel("Bacon Cheeseburger","Beef patty with melted cheese", R.drawable.baconcheeseburger, 0));
            items.add(new DynamicRVModel("Shawarma Burger","Traditional Middle Eastern shawarma", R.drawable.shawarmaburger, 0));
            items.add(new DynamicRVModel("Muffaletta Burger","New Orleans Muffaletta burger", R.drawable.muffalettaburger, 0));
            items.add(new DynamicRVModel("Kimchi Burger","Fusion of Korean & American cuisines", R.drawable.kimchiburger, 0));
            items.add(new DynamicRVModel("Nutburger","Blend of nuts, grains, and veggies", R.drawable.nutburger, 0));
            items.add(new DynamicRVModel("Slaw Burger","Delicious twist on the classic burger", R.drawable.slawburger, 0));

            updateRecyclerView.callback(position, items);
            check = false;

        }

        holder.linearLayout.setOnClickListener(v -> {
            setSelectedPosition(position);

            if (position==0){

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Mexican Burger","Blend of seasoned ground beef", R.drawable.mexicanburger, 0));
                items.add(new DynamicRVModel("Cheese Burger"," Juicy patty with melted cheese", R.drawable.cheeseburger, 0));
                items.add(new DynamicRVModel("Turkey Burger"," Crafted from ground turkey meat", R.drawable.turkeyburger, 0));
                items.add(new DynamicRVModel("Veggie Burger"," Blend of veggies, grains and spices", R.drawable.veggieburger, 0));
                items.add(new DynamicRVModel("Bean Burger","Hearty vegetarian mashed beans", R.drawable.beanburger, 0));
                items.add(new DynamicRVModel("Wild Salmon Burger","Made from fresh wild-caught salmon", R.drawable.wildsalmonburger, 0));
                items.add(new DynamicRVModel("Hamburger","American staple, grilled beef patty", R.drawable.hamburger, 0));
                items.add(new DynamicRVModel("Portobello Burger","Large Portobello mushroom cap grill", R.drawable.portbelloburger, 0));
                items.add(new DynamicRVModel("Elk Burger","Elk meat with herbs and spices", R.drawable.elkburger, 0));
                items.add(new DynamicRVModel("Beyond meat Burger","Blend of pea protein & coconut oil", R.drawable.beyondmeatburger, 0));
                items.add(new DynamicRVModel("Buffalo Burger","Buffalo meat, from American bison", R.drawable.buffaloburger, 0));
                items.add(new DynamicRVModel("Bacon Cheeseburger","Beef patty with melted cheese", R.drawable.baconcheeseburger, 0));
                items.add(new DynamicRVModel("Shawarma Burger","Traditional Middle Eastern shawarma", R.drawable.shawarmaburger, 0));
                items.add(new DynamicRVModel("Muffaletta Burger","New Orleans Muffaletta burger", R.drawable.muffalettaburger, 0));
                items.add(new DynamicRVModel("Kimchi Burger","Fusion of Korean & American cuisines", R.drawable.kimchiburger, 0));
                items.add(new DynamicRVModel("Nutburger","Blend of nuts, grains, and veggies", R.drawable.nutburger, 0));
                items.add(new DynamicRVModel("Slaw Burger","Delicious twist on the classic burger", R.drawable.slawburger, 0));

                updateRecyclerView.callback(position, items);
            } else if (position==1){

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Margherita Pizza","Classic Italian pizza with Cheese", R.drawable.margheritapizza ,1));
                items.add(new DynamicRVModel("BBQ Chicken Pizza","Tangy sauce, tender chicken, cheese", R.drawable.bbqchickenpizza,1));
                items.add(new DynamicRVModel("Pepperoni Pizza","Zesty pepperoni & melted cheese.", R.drawable.pepperonipizza,1));
                items.add(new DynamicRVModel("Hawaiian Pizza","Pineapple, ham, & melted cheese.", R.drawable.hawaiianpizza,1));
                items.add(new DynamicRVModel("Meat Lover's Pizza","Assorted savory meats & cheese.", R.drawable.meatoverspizza,1));
                items.add(new DynamicRVModel("Veggie Pizza","Fresh veggies, melty cheese & crust.", R.drawable.veggiepizza,1));
                items.add(new DynamicRVModel("Cheese Pizza","Perfection of melted cheese & crust.", R.drawable.cheesepizza,1));
                items.add(new DynamicRVModel("Mushroom Pizza","Mushrooms, melted cheese, crispy crust.", R.drawable.mushroompizza,1));
                items.add(new DynamicRVModel("Sausage Pizza","Sausage, gooey cheese, crispy crust.", R.drawable.sausagepizza,1));
                items.add(new DynamicRVModel("Buffalo Pizza","Buffalo sauce, chicken & cheese.", R.drawable.buffalopizza,1));
                items.add(new DynamicRVModel("Neapolitan Pizza","Traditional Italian, thin crust.", R.drawable.neapolitanpizza,1));
                items.add(new DynamicRVModel("Chicago style pizza","Deep-dish delight, cheese & toppings.", R.drawable.chicagostylepizza,1));
                items.add(new DynamicRVModel("Bagel pizza","Mini pizzas, bagel crusts, toppings.", R.drawable.bagelpizza,1));
                items.add(new DynamicRVModel("Roman pizza","Thin crust, flavorful toppings.", R.drawable.romanpizza,1));
                items.add(new DynamicRVModel("New York Style Pizza","Thin slices, classic cheesy goodness.", R.drawable.newyorkstylepizza,1));
                items.add(new DynamicRVModel("Sicilian Style Pizza","Fluffy crust, with robust flavors.", R.drawable.sicilianstylepizza,1));
                items.add(new DynamicRVModel("Detroit Style Pizza","Thick crust, caramelized cheese edges.", R.drawable.detroitstylepizza,1));

                updateRecyclerView.callback(position, items);
            } else if (position==2){

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Cappuccino","Espresso, frothy foam, heavenly aroma", R.drawable.cappachino, 2));
                items.add(new DynamicRVModel("Affogato","Creamy gelato in hot espresso.", R.drawable.affogato, 2));
                items.add(new DynamicRVModel("Americano","Espresso with hot water, bold flavor.", R.drawable.americano, 2));
                items.add(new DynamicRVModel("Café au lait","French-styled, equal coffee & milk.", R.drawable.cafeaulait, 2));
                items.add(new DynamicRVModel("Caffe Breve","Espresso with steamed half-and-half", R.drawable.caffebreve, 2));
                items.add(new DynamicRVModel("Black Coffee","Brewed coffee, no additives.", R.drawable.blackcoffee, 2));
                items.add(new DynamicRVModel("Con Panna","Whipped cream, indulgent delight", R.drawable.conpanna, 2));
                items.add(new DynamicRVModel("Cortado","Equal parts espresso and steamed milk.", R.drawable.cortado, 2));
                items.add(new DynamicRVModel("Flat White","Smooth espresso, velvety steamed milk.", R.drawable.flatwhite, 2));
                items.add(new DynamicRVModel("Frappuccino","Blended coffee, ice, milk, syrup.", R.drawable.frappuccino, 2));
                items.add(new DynamicRVModel("Iced Coffee","Chilled coffee served over ice cubes.", R.drawable.icedcoffee, 2));
                items.add(new DynamicRVModel("Irish Coffee","Coffee, Irish whiskey, topped, cream.", R.drawable.irishcoffee, 2));
                items.add(new DynamicRVModel("Lungo","Espresso shot, extracted long time.", R.drawable.lungo, 2));
                items.add(new DynamicRVModel("Mocha","Chocolate syrup, whipped cream.", R.drawable.mocha, 2));
                items.add(new DynamicRVModel("Red Eye","Drip coffee with a shot of espresso.", R.drawable.redeye, 2));
                items.add(new DynamicRVModel("Turkish Coffee","Finely ground coffee boiled, sugar", R.drawable.turkishcoffee, 2));
                items.add(new DynamicRVModel("Vienna","Coffee topped with whipped cream.", R.drawable.vienna, 2));
                updateRecyclerView.callback(position, items);

            } else if (position==3){

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Virgin pina colada","Pineapple, coconut cream, no alcohol.", R.drawable.virginpinacolada, 3));
                items.add(new DynamicRVModel("Spicy Watermelon","Refreshing with a hint of heat.", R.drawable.spicywatermelonmocktail, 3));
                items.add(new DynamicRVModel("Cranberry sangria","Fruity, tart, refreshing, non-alcoholic.", R.drawable.cranberrysangria, 3));
                items.add(new DynamicRVModel("Shirley Temple","Sweet, fizzy, grenadine, ginger ale.", R.drawable.shirleytemple, 3));
                items.add(new DynamicRVModel("Virgin Mary","Tangy tomato juice, no alcohol.", R.drawable.virginmary, 3));
                items.add(new DynamicRVModel("Berry Cooler","Refreshing blend of mixed berries.", R.drawable.berrycooler, 3));
                items.add(new DynamicRVModel("Virgin margarita","Tangy lime, sweetened, salted rim.", R.drawable.virginmargarita, 3));
                items.add(new DynamicRVModel("Strawberry daiquiri","Sweet, fruity, blended, alcohol-free version.", R.drawable.virginstrawberrydaiquiri, 3));
                items.add(new DynamicRVModel("Hurricane Mocktail","Fruity, tropical, non-alcoholic rendition.", R.drawable.hurricanemocktail, 3));
                items.add(new DynamicRVModel("Lavender lemonade","Floral, citrusy, summer beverage.", R.drawable.lavenderlemonade, 3));
                items.add(new DynamicRVModel("Negroni mocktail","Bittersweet, citrusy, alcohol-free version.", R.drawable.negronimocktail, 3));
                items.add(new DynamicRVModel("Virgin Gimlet","Tangy, lime-infused, non-alcoholic.", R.drawable.virgincucumbergimlet, 3));
                items.add(new DynamicRVModel("Arnold Palmer","Refreshing blend of iced tea & lemonade.", R.drawable.arnoldpalmer, 3));
                items.add(new DynamicRVModel("Cherry Punch","Sweet, fruity, non-alcoholic beverage.", R.drawable.cherrypunch, 3));
                items.add(new DynamicRVModel("Citrus Fizz","Zesty, bubbly, refreshing, tangy drink.", R.drawable.citrusfizz, 3));
                items.add(new DynamicRVModel("Dragonfruit mocktail","Vibrant, exotic, fruity, alcohol-free.", R.drawable.dragonfruitmocktail, 3));
                items.add(new DynamicRVModel("Frozen lemonade","Chilled, slushy, tangy, citrus treat.", R.drawable.frozenlemonade, 3));

                updateRecyclerView.callback(position, items);

            } else if (position==4) {

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Standard French Fries","Classic, crispy, golden potato sticks.", R.drawable.thestanderdcut, 4));
                items.add(new DynamicRVModel("Steak Fries","Thick-cut, hearty, potato wedges.", R.drawable.steakfries, 4));
                items.add(new DynamicRVModel("Crinkle Cut Fries","Wavy, crispy, fun-shaped potato slices.", R.drawable.crinklecutfries, 4));
                items.add(new DynamicRVModel("Shoestring Fry","Thin, crispy, delicate potato strands.", R.drawable.shoestringfry, 4));
                items.add(new DynamicRVModel("Matchstick Fry","Thin, crisp, slender potato sticks.", R.drawable.matchstick, 4));
                items.add(new DynamicRVModel("Waffle Fries","Crispy, lattice-shaped potato slices.", R.drawable.wafflefries, 4));
                items.add(new DynamicRVModel("Wedge-cut fries","Thick, hearty potato wedges, crispy.", R.drawable.wedgecutfries, 4));
                items.add(new DynamicRVModel("Cheese fries","Fries smothered & melted cheese.", R.drawable.cheesefries, 4));
                items.add(new DynamicRVModel("Cottage Fry","Rustic, chunky potato wedges, skin-on.", R.drawable.cottage, 4));
                items.add(new DynamicRVModel("Potato Tornado","Spiral-cut potato skewered and fried.", R.drawable.potatotornado, 4));
                items.add(new DynamicRVModel("Garlic fries","Crispy fries tossed in garlic butter.", R.drawable.garlicfries, 4));
                items.add(new DynamicRVModel("Curly Fries","Spiraled, seasoned, potato delights.", R.drawable.curlyfries, 4));
                items.add(new DynamicRVModel("Truffle Fries","Fries drizzled on truffle oil, decadent.", R.drawable.trufflefries, 4));
                items.add(new DynamicRVModel("Animal-style Fries","Crispy fries, cheese, grilled onions.", R.drawable.animalstylefrenchfries, 4));
                items.add(new DynamicRVModel("Poutine Hails","Classic Canadian comfort food—fries.", R.drawable.poutinehails, 4));
                items.add(new DynamicRVModel("Loaded French Fries","Fries piled high with toppings.", R.drawable.loadedfrenchfries, 4));
                items.add(new DynamicRVModel("Honey Butter Fries","Fries drizzled, sweet honey butter.", R.drawable.honeybutterfries, 4));

                updateRecyclerView.callback(position, items);

            } else if (position==5) {

                ArrayList<DynamicRVModel> items = new ArrayList<DynamicRVModel>();
                items.add(new DynamicRVModel("Pinwheel Sandwich","Rolled fillings in flatbread, colorful bites.", R.drawable.pinwheelsandwiches, 5));
                items.add(new DynamicRVModel("Grilled Sandwich","Melted cheese, toasted bread slices.", R.drawable.grilledcheesesandwich, 5));
                items.add(new DynamicRVModel("Club Sandwich","Triple-decker with meats, veggies.", R.drawable.clubsandwich,5));
                items.add(new DynamicRVModel("Falafel","Fried chickpea balls, in pita pocket.", R.drawable.falafel, 5));
                items.add(new DynamicRVModel("Vegetable Sandwich","Fresh veggies layered in bread slices.", R.drawable.vegetablesandwich, 5));
                items.add(new DynamicRVModel("Chicken Sandwich","Grilled or fried chicken on bun.", R.drawable.chickensandwich, 5));
                items.add(new DynamicRVModel("Egg Sandwich","Scrambled & fried eggs in bread.", R.drawable.eggsandwich, 5));
                items.add(new DynamicRVModel("Ham Sandwich","Slices of ham between bread slices.", R.drawable.hamsandwich, 5));
                items.add(new DynamicRVModel("Bánh mì","Vietnamese sandwich, various fillings.", R.drawable.binhmi, 5));
                items.add(new DynamicRVModel("Sabich Sandwich","Israeli pita, fried eggplant, eggs.", R.drawable.sabichsandwich, 5));
                items.add(new DynamicRVModel("Meatball Sandwich","Juicy meatballs in bread roll.", R.drawable.meatballsandwich, 5));
                items.add(new DynamicRVModel("Nutella sandwich","Sweet hazelnut spread in bread.", R.drawable.nutellasandwich, 5));
                items.add(new DynamicRVModel("Reuben sandwich","Beef, sauerkraut, Swiss cheese.", R.drawable.reubensandwich, 5));
                items.add(new DynamicRVModel("French Sandwich","Baguette with meats & cheese.", R.drawable.frenchsandwich, 5));
                items.add(new DynamicRVModel("Roast-Beef Sandwich","Slices of roasted beef on bread.", R.drawable.roastbeef, 5));
                items.add(new DynamicRVModel("Salmon Sandwich","Smoked or grilled salmon, bread.", R.drawable.salmonsandwich, 5));
                items.add(new DynamicRVModel("Olive Sandwich","Sliced olives between bread slices.", R.drawable.olivesandwich, 5));

                updateRecyclerView.callback(position, items);
            }
        });

        if (select) {
            if (position == 0) {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
                select = false;
            }
        }

        else {
            if (selectedPosition == position) {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            } else {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
            }
        }
        }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRvViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;
        LinearLayout linearLayout;

        public StaticRvViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}

package com.example.homework_2_8;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView categoryRecyclerView, foodRecyclerView;
    private CategoryAdapter categoryAdapter;
    private FoodAdapter foodAdapter;
    private List<Category> categoryList;
    private List<Food> burgerList, pizzaList, chickenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        categoryRecyclerView = findViewById(R.id.category_recycler_view);
        foodRecyclerView = findViewById(R.id.food_recycler_view);

        // Инициализация категорий
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Burgers", R.drawable.burger));
        categoryList.add(new Category("Pizza", R.drawable.pizza));
        categoryList.add(new Category("Chicken", R.drawable.chicken));

        categoryAdapter = new CategoryAdapter(categoryList, this, new CategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(int position) {
                switch (position) {
                    case 0:
                        foodAdapter.updateFoodList(burgerList); // Показать бургеры
                        break;
                    case 1:
                        foodAdapter.updateFoodList(pizzaList); // Показать пиццы
                        break;
                    case 2:
                        foodAdapter.updateFoodList(chickenList); // Показать курицу
                        break;
                }
            }
        });
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoryRecyclerView.setAdapter(categoryAdapter);

        // Инициализация еды для каждой категории
        burgerList = new ArrayList<>();
        burgerList.add(new Food("Salad Burger", 12, String.valueOf(R.drawable.burger)));
        burgerList.add(new Food("Cheese Burger", 14, String.valueOf(R.drawable.burger)));
        burgerList.add(new Food("Bacon Burger", 16, String.valueOf(R.drawable.burger)));

        pizzaList = new ArrayList<>();
        pizzaList.add(new Food("Pepperoni Pizza", 10, "R.drawable.burger"));
        pizzaList.add(new Food("Margarita Pizza", 11, "R.drawable.burger"));
        pizzaList.add(new Food("Veggie Pizza", 9, "R.drawable.burger"));

        chickenList = new ArrayList<>();
        chickenList.add(new Food("Fried Chicken", 15, "R.drawable.burger"));
        chickenList.add(new Food("Grilled Chicken", 17, "R.drawable.burger"));
        chickenList.add(new Food("Spicy Chicken", 18, "R.drawable.burger"));

        // Инициализация адаптера еды с первой категорией по умолчанию (Burgers)
        foodAdapter = new FoodAdapter(burgerList, this);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        foodRecyclerView.setAdapter(foodAdapter);
    }
}

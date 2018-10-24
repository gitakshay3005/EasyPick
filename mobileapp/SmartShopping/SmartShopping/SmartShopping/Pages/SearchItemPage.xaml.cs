using System.Collections.Generic;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SmartShopping.Pages
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class SearchItemPage : ContentPage
    {
        public SearchItemPage()
        {
            InitializeComponent();
            DataNotAvailableLayout.IsVisible = false;
            NodataLbl.IsVisible = false;
        }

        protected override void OnAppearing()
        {
            base.OnAppearing();
            productSearchbar.Focus();
        }

        protected override void OnDisappearing()
        {
            base.OnDisappearing();
            productSearchbar.Unfocus();
        }

        private void StoresListView_ItemTapped(object sender, ItemTappedEventArgs e)
        {           
            var item = e.Item as string;
            Navigation.PushAsync(new CreateOrderPage(item));
        }

        private void ProductSearchbar_SearchButtonPressed(object sender, System.EventArgs e)
        {
            if (productSearchbar.Text.Length < 4)
                DisplayAlert("Alert", "please enter minimum 4 letters", "ok");
            else
                StoresListView.ItemsSource = new List<string> { "result1", "result2", "result3", "result4" };
        }

        private void ProductSearchbar_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (productSearchbar.Text.Length >= 4)
                StoresListView.ItemsSource = new List<string> { "result1", "result2", "result3", "result4" };
        }
    }
}
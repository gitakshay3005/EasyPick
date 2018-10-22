using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SmartShopping.Pages
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class HomePage : ContentPage
	{
		public HomePage ()
		{
			InitializeComponent ();
		}

        private void CreateorderBtn_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new SearchItemPage());
        }

        private void MyorderBtn_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new MyOrderPage());
        }

        private void AboutBtn_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new AboutPage());
        }

        private void HelpBtn_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new HelpPage());
        }
    }
}
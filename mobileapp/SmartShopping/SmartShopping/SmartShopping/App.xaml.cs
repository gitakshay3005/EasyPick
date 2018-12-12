using SmartShopping.DatabaseHelper;
using SmartShopping.DatabaseHelper.Tables;
using SmartShopping.Pages;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

[assembly: XamlCompilation(XamlCompilationOptions.Compile)]
namespace SmartShopping
{
    public partial class App : Application
    {
        public App()
        {
            InitializeComponent();
            DBAccess dbaccess = DBAccess.Instance;
            dbaccess.CreateTable<Product>();
            MainPage = new NavigationPage(new LoginPage());
        }

        protected override void OnStart()
        {
            // Handle when your app starts
        }

        protected override void OnSleep()
        {
            // Handle when your app sleeps
        }

        protected override void OnResume()
        {
            // Handle when your app resumes
        }
    }
}

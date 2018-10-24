using SmartShopping.Droid.Helpers;
using SmartShopping.Interfaces;
using SQLite;
using System;
using System.IO;

[assembly: Xamarin.Forms.Dependency(typeof(DBConnectionService))]
namespace SmartShopping.Droid.Helpers
{
    public class DBConnectionService : IDBConnectionService
    {
        string GetPath(string databaseName)
        {
            if (string.IsNullOrWhiteSpace(databaseName))
            {
                throw new ArgumentException("Invalid database name", nameof(databaseName));
            }
            var sqliteFilename = $"{databaseName}.db3";
            var documentsPath = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal);
            var path = Path.Combine(documentsPath, sqliteFilename);
            return path;
        }

        public SQLiteConnection GetConnection(string filename)
        {
            return new SQLiteConnection(GetPath(filename));
        }        
    }
}
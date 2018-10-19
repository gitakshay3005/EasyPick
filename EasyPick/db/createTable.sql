-- CREATE DATABASE EasyPick;   -- Only Once One member will un it in start . 

-- USE EasyPick


-- USER 

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[USER]') AND type in (N'U'))
CREATE TABLE [dbo].[USER](

ID [bigint] NOT NULL,
FirstName [nvarchar](128) NOT NULL,
LastName [nvarchar](128) NOT NULL,
EmailId [nvarchar](256) NOT NULL,
Password [nvarchar](128) NOT NULL,
UserType [char](1) NOT NULL

)


---------------------------------------------------------------------------------
--Product

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Product]') AND type in (N'U'))
CREATE TABLE [dbo].[Product](

ID [bigint] NOT NULL,
UPC [bigint] NOT NULL,
Name [nvarchar](256) NOT NULL,
Category [nvarchar](128) NOT NULL,
Description [nvarchar](256) NULL,
Supplier [nvarchar](128) NOT NULL

)





---------------------------------------------------------------------------------

--Store

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Store]') AND type in (N'U'))
CREATE TABLE [dbo].[Store](

ID [bigint] NOT NULL,
Store_ID [bigint] NOT NULL,
Name [nvarchar](128) NOT NULL,
City [nvarchar](128) NOT NULL,
Address [nvarchar](256) NOT NULL,
Country [nvarchar](128) NOT NULL,
Lattitude decimal (10,4) NOT NULL,
Longitde decimal (10,4) NOT NULL,
Retailer [nvarchar](128) NOT NULL
)




-----------------------------------------------------------------------------------
--STORE_PRODUCT_RELATION

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[STORE_PRODUCT_RELATION]') AND type in (N'U'))
CREATE TABLE [dbo].[STORE_PRODUCT_RELATION](
ID [bigint] NOT NULL,
Store_ID [bigint] NOT NULL,
Product_ID [bigint] NOT NULL,
Avail_QTY [bigint] NULL,
UNit_Price decimal (10,4) NOT NULL,
)




---------------------------------------------------------------------------

--Orders

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Orders]') AND type in (N'U'))
CREATE TABLE [dbo].[Orders](

ID [bigint] NOT NULL,
ORDER_TYPE [char](1) NOT NULL,
Payment_type [char](1) NOT NULL,
Delivery_type [char](1) NOT NULL,
Delivery_date [datetime] NOT NULL,
User_ID [bigint] NOT NULL

)




-------------------------------------------------------------------------------------------
--ORDER_PRODUCT_STORE_MAPPING

IF  NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ORDER_PRODUCT_STORE_MAPPING]') AND type in (N'U'))
CREATE TABLE [dbo].[ORDER_PRODUCT_STORE_MAPPING](

ID [bigint] NOT NULL, 
ORDER_ID [bigint] NOT NULL,
STORE_ID [bigint] NOT NULL,
Product_ID [bigint] NOT NULL,
ORDERED_QTY [bigint] NULL,

)







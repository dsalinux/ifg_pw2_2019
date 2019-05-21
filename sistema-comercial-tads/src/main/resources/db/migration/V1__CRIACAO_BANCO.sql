/* Implementaçãdo do sistema */
CREATE TABLE public.categoria (
    id serial NOT NULL,
    nome varchar(40) NOT NULL,
    categoria_id integer references public.categoria(id),
    PRIMARY KEY (id)
);

CREATE TABLE public.usuario (
    id SERIAL NOT NULL,
    nome varchar(60) NOT NULL,
    email varchar(100) NOT NULL,
    senha varchar(100) NOT NULL,
    data_cadastro date NOT NULL,
    data_desativacao timestamp,
    PRIMARY KEY (id)
);

CREATE TABLE public.permissao (
    id Serial NOT NULL,
    nome varchar(50) NOT NULL,
    descricao varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE public.usuario_has_permissao (
    usuario_id integer NOT NULL references public.usuario(id),
    permissao_id integer NOT NULL references public.permissao(id),
    PRIMARY KEY (usuario_id, permissao_id)
);

CREATE TABLE public.cliente (
    id serial NOT NULL,
    nome varchar NOT NULL,
    apelido_fantasia varchar,
    cpf varchar(20),
    rg varchar(20),
    cnpj varchar(20),
    inscricao varchar(20),
    telefone1 varchar(20),
    telefone2 varchar(20),
    telefone3 varchar(20),
    email varchar(120),
    observacao varchar(150) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.endereco (
    id serial NOT NULL,
    logradouro varchar(80) NOT NULL,
    numero varchar(20) NOT NULL,
    complemento varchar(60),
    bairro varchar(80) NOT NULL,
    cidade varchar(100) NOT NULL,
    pais varchar(100) NOT NULL,
    cep varchar(20) NOT NULL,
    cliente_id integer NOT NULL,
    cobranca boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.produto (
    id serial NOT NULL,
    nome varchar(100) NOT NULL,
    marca varchar(50),
    categoria_id integer NOT NULL references public.categoria(id),
    unidade varchar(3) NOT NULL,
    codigo_barras varchar(100),
    PRIMARY KEY (id)
);

CREATE TABLE public.fornecedor (
    id serial NOT NULL,
    nome varchar(100) NOT NULL,
    cnpj varchar(20),
    cpf varchar(20),
    inscricao varchar(20),
    rg varchar(20),
    telefone1 varchar(20),
    telefone2 varchar(20),
    email varchar(120),
    website varchar(150),
    PRIMARY KEY (id)
);

CREATE TABLE public.movimento_estoque (
    id serial NOT NULL,
    produto_id integer NOT NULL references public.produto(id),
    fornecedor_id integer references public.fornecedor(id),
    tipo_movimento varchar(10) NOT NULL,
    data_movimento timestamp NOT NULL,
    quantidade decimal NOT NULL,
    preco_custo decimal(10,2) NOT NULL,
    observacao varchar(100),
    PRIMARY KEY (id)
);


CREATE TABLE public.pedido (
    id serial NOT NULL,
    cliente_id integer NOT NULL references public.cliente(id),
    endereco_entrega_id integer NOT NULL references public.endereco(id), 
    data_pedido date NOT NULL,
    observacoes varchar(150),
    observacoes_cliente varchar(150),
    usuario_id integer NOT NULL references public.usuario(id),
    desconto decimal(10,2),
    PRIMARY KEY (id)
);


CREATE TABLE public.pedido_has_produto (
    produto_id integer NOT NULL references public.produto(id),
    pedido_id integer NOT NULL references public.pedido(id),
    valor decimal(10,1) NOT NULL,
    quantidade decimal(10,2) NOT NULL,
    PRIMARY KEY (produto_id, pedido_id)
);

CREATE TABLE public.conta (
    id serial NOT NULL,
    nome varchar(80) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.fluxo_caixa (
    id Serial NOT NULL,
    descricao varchar(100) NOT NULL,
    tipo_movimento varchar(20) NOT NULL,
    pedido_id integer references public.pedido(id),
    valor decimal(10,2) NOT NULL,
    data_movimento timestamp NOT NULL,
    conta_id integer NOT NULL references public.conta(id),
    PRIMARY KEY (id)
);

INSERT INTO public.usuario(nome, email, senha, data_cadastro, data_desativacao)	VALUES ('IFG', 'ifg@ifg.edu.br', '123', '2019-05-14', null);